package org;

import java.io.*;
import java.util.*;
import java.net.*;

/**
 * Menangani POST request
 * NOTE: object hanya bisa dipakai sekali. Setelah di-eksekusi, harus di-inisialisasi ulang.
 * @author Alvin Natawiguna
 *
 */
public class ServerPOST {
	private static final int bufferSize = 4096;
	
	private final String boundary;
	private String charset;
	private static final String LINE_FEED = "\r\n";
	private HttpURLConnection httpConn;
	private OutputStream outputStream;
	private PrintWriter writer;
	private boolean executed;
	
	/**
	 * Konstruktor ServerPOST:
	 * Menginisialisasi semua atribut yang dipakai
	 * @param requestURL URL yang dituju
	 * @param charset character set yang dipakai.
	 * @throws IOException
	 */
	public ServerPOST(String requestURL, String charset) 
			throws IOException	{
		// buat boundary berdasarkan timestamp
		boundary = "===" + System.currentTimeMillis() + "===";
		
		// buka koneksi
		URL url = new URL(requestURL);
		httpConn = (HttpURLConnection) url.openConnection();
		
		// properties
		httpConn.setUseCaches(false);
		httpConn.setDoOutput(true); // POST
		httpConn.setDoInput(false);
		httpConn.setRequestProperty("Content-Type",
				"multipart/form-data; boundary="+boundary);
		httpConn.setRequestProperty("User-Agent", "BookBay Agent");
		
		// passing semua atribut yang bakal dipakai
		outputStream = httpConn.getOutputStream();
		writer = new PrintWriter(new OutputStreamWriter(outputStream, charset),
				true);
		this.charset = charset;
		executed = false;
	}
	
	/**
	 * Menambahkan field form pada request
	 * @param name nama field
	 * @param value nilai field
	 */
	public void addFormField(String name, String value) {
		// pasang boundary
		writer.append("--").append(boundary).append(LINE_FEED);
		
		// masukkan nama
		writer.append("Content-Disposition: form-data; name=\"").append(name).append(LINE_FEED);
		
		// masukkan charset
		writer.append("Content-Type: text/plain; charset=").append(charset).append(LINE_FEED);
		
		// masukkan nilai
		writer.append(value).append(LINE_FEED);
		
		// bersih-bersih
		writer.flush();
	}
	
	/**
	 * Upload sebuah file ke request
	 * 
	 * @param fieldName nama field di <input type="file" name="..." />
	 * @param uploadFile file yang mau di-upload
	 */
	public void addFile(String fieldName, File uploadFile) 
		throws IOException
	{
		String fileName = uploadFile.getName();
		
		// pasang boundary
		writer.append("--").append(boundary).append(LINE_FEED);
		
		// pasang header file
		writer.append("Content-Disposition: form-data; name=\"").append(fieldName).append("\"");
		writer.append("; filename=\"").append(fileName).append("\"").append(LINE_FEED);
		writer.append("Content-Type: ").append(URLConnection.guessContentTypeFromName(fileName)).append(LINE_FEED);
		writer.append("Content-Transfer-Encoding: binary").append(LINE_FEED);
		writer.append(LINE_FEED);
		writer.flush();
		
		// tulis filenya
		FileInputStream inputStream = new FileInputStream(uploadFile);
		byte buffer[] = new byte[bufferSize];
		int bytesRead = -1;
		while((bytesRead = inputStream.read(buffer)) != -1) {
			outputStream.write(buffer, 0, bytesRead);
		}
		
		// tutup
		outputStream.flush();
		inputStream.close();
		
		writer.append(LINE_FEED);
		writer.flush();
	}
	
	/**
	 * Tambahkan header field ke request
	 * @param name nama header field
	 * @param value nilai header field
	 */
	public void addHeaderField(String name, String value) {
		writer.append(name).append(": ").append(value).append(LINE_FEED);
		writer.flush();
	}
	
	/**
	 * Eksekusi POST request
	 * @return response dari server
	 * @throws IOException
	 */
	public List<String> execute() throws IOException {
		List<String> response = null;
		
		if(!executed) {
			response = new ArrayList<String>();
			
			// tulis bagian bawahnya~
			writer.append(LINE_FEED).flush();
			writer.append("--").append(boundary).append("--").append(LINE_FEED);
			writer.close();
			
			executed = true;
			
			// cek status
			int status = httpConn.getResponseCode();
			if(status == HttpURLConnection.HTTP_OK) {
				// baca response
				BufferedReader reader = new BufferedReader(new InputStreamReader(
						httpConn.getInputStream()));
				String line = null;
				while((line = reader.readLine()) != null) {
					response.add(line);
				}
				reader.close();
				httpConn.disconnect();
			} else {
				throw new IOException("Server returned non-OK status: " + status);
			}
		} else {
			throw new IOException("Request has already been executed!");
		}
		
		return response;
	}
}
