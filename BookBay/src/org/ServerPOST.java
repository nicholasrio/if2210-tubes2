package org;
import java.io.*;
import java.util.*;
import java.net.*;

/**
 * Menangani POST request
 * NOTE: object hanya bisa dipakai sekali. Setelah di-eksekusi, object baru harus dibuat.
 * @author Alvin Natawiguna
 *
 */
public class ServerPOST {
	private static int bufferSize = 4096; // buffer size, in bytes
	private static String agentName = "BookBay Agent";
	private static final String LINE_FEED = "\r\n"; // untuk keperluan newline
	
	private final String boundary; // boundary u/ request
	
	private HttpURLConnection httpConn; // koneksi ke HTTP URL
	private OutputStream outputStream; // outputStream: untuk file
	private PrintWriter writer; // writer: untuk nulis ke stream
	private String charset; // charset yang dipakai
	private boolean executed; // status: sudah dieksekusi atau belum
	private boolean download; // download: akan melakukan pengunduhan atau tidak
	
	/**
	 * Mengambil ukuran buffer yang sekarang terpasang
	 * @return buffer size
	 */
	public static int bufferSize() {
		return bufferSize;
	}
	
	/**
	 * Mengubah ukuran buffer
	 * @param size ukuran buffer yang baru
	 */
	public static void bufferSize(int size) {
		bufferSize = size;
	}
	
	/**
	 * Konstruktor ServerPOST:
	 * Menginisialisasi semua atribut yang dipakai
	 * @param requestURL URL yang dituju
	 * @param charset character set yang dipakai.
	 * @param download koneksi digunakan untuk download file
	 * @throws IOException
	 */
	public ServerPOST(String requestURL, String charset, boolean download) 
			throws IOException	{
		// buat boundary berdasarkan timestamp
		boundary = "===" + System.currentTimeMillis() + "===";
		
		// buka koneksi
		URL url = new URL(requestURL);
		httpConn = (HttpURLConnection) url.openConnection();
		
		// properties
		httpConn.setUseCaches(false);
		httpConn.setRequestMethod("POST");
		httpConn.setDoOutput(true); // POST
		httpConn.setDoInput(true);
		httpConn.setRequestProperty("Content-Type",	"multipart/form-data; boundary=\"" + boundary + "\"");
		httpConn.setRequestProperty("User-Agent", agentName);
		
		// passing semua atribut yang bakal dipakai
		outputStream = httpConn.getOutputStream(); // untuk POST request
		writer = new PrintWriter(new OutputStreamWriter(outputStream, charset),
				true);
		this.charset = charset.toLowerCase();
		executed = false;
		this.download = download;
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
		writer.append("Content-Disposition: form-data; name=\"").append(name).append('"').append(LINE_FEED);
		
		// masukkan charset
		writer.append("Content-Type: text/plain; charset=").append(charset).append(LINE_FEED);
		
		// masukkan nilai
		writer.append(LINE_FEED);
		writer.append(value.trim());
		writer.append(LINE_FEED);
		
		// tulis
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
		
		// newline~
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
			if(!download) {
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
				throw new IOException("You need to use another method to download the file");
			}
		} else {
			throw new IOException("Request had already been executed!");
		}
		
		return response;
	}
	
	public void execute(File outputFile) throws IOException {
		assert(outputFile != null);
		
		if(!executed) {
			if(download) {
				// tulis bagian bawahnya~
				writer.append(LINE_FEED).flush();
				writer.append("--").append(boundary).append("--").append(LINE_FEED);
				writer.close();
				
				executed = true;
				
				// cek status koneksi
				int status = httpConn.getResponseCode();
				if(status == HttpURLConnection.HTTP_OK) {
					// baca file yang didapat
					InputStream in = httpConn.getInputStream();
					FileOutputStream fos = new FileOutputStream(outputFile);
					System.out.println("Reading file...");
					
					int length = -1;
					int bytesWritten = 0;
					byte buffer[] = new byte[bufferSize];
					
					while((length = in.read(buffer)) > -1) {
						fos.write(buffer, 0, length);
						bytesWritten += length;
					}
					System.out.println("Written " + bytesWritten + " bytes");
					
					// tutup
					
					fos.close();
					in.close();
					outputStream.close();
					httpConn.disconnect();
				} else {
					throw new IOException("Server returned non-OK status: " + status);
				}
			} else {
				throw new IOException("This method is intended only to download file.");
			}
		} else {
			throw new IOException("Request had already been executed!");
		}
	}
}
