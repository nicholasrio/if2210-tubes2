package org;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public interface IFileController extends Controller {
	/**
	 * Mengubah view. Berguna ketika akan menghancurkan view yang ada.
	 * @param view interface dari file
	 */
	public void registerView(IFileView view);
	
	/**
	 * Mengubah model. Berguna ketika mau menginisialisasi fileController baru
	 * @param model file
	 */
	public void registerModel(FileExt model);
	
	/**
	 * Memeriksa apakah model kosong (null)
	 * @return true jika model kosong
	 */
	public boolean isModelEmpty();
	
	// File getters-setters
	/**
	 * Mendapatkan nama file dari server
	 * @return named name
	 */
	public String getFileNamedName();
	
	/**
	 * Mengubah nama file yang ada di server
	 * @param name nama baru file
	 */
	public void setFileNamedName(String name);
	
	/**
	 * Mendapatkan lokasi file fisik
	 * @return Lokasi file fisik
	 */
	public String getFileLocation();	
	
	/**
	 * Mendapatkan ukuran file sesungguhnya
	 * @return ukuran file
	 */
	public long getFileSize();
	
	/**
	 * Mendapatkan referensi ke pengunggah file
	 * @return referensi ke pengunggah file
	 */
	public User getFileUploader();
	
	/**
	 * Mengembalikan download count dari file
	 * @return download count
	 */
	public long getFileDownloadCount();
	
	/**
	 * Mendapatkan kategori file dalam representasi String
	 * @return kategori file
	 */
	public String getFileCategory();
	
	/**
	 * Mengubah kategori file
	 * @param cat FileCategory yang baru
	 */
	public void setFileCategory(FileCategory cat);
	
	/**
	 * Mendapatkan upload time dari file,
	 * dalam representasi java.util.Date
	 * @return waktu upload file
	 */
	public Date getFileUploadTime();
	
	/**
	 * Mendapatkan deskripsi file
	 * @return file description
	 */
	public String getFileDescription();
	
	/**
	 * Mengubah deskripsi file
	 * @param desc deskripsi file yang baru
	 */
	public void setFileDescription(String desc);
	
	// File Operations
	/**
	 * Melakukan upload file
	 * NOTE: akan mengganti fileView yang ada ke file ini
	 * @throws IOException
	 */
	public void upload() throws IOException;
	
	/**
	 * Melakukan download file
	 * @param saveLocation File ke lokasi penyimpnanan
	 * @param user User yang melakukan download
	 * @throws IOException
	 */
	public void download(File saveLocation, User user) throws IOException;
	
	/**
	 * Melakukan rename terhadap file yang terhubung
	 * @param newName nama file yang baru
	 * @throws SecurityException jika terdapat pelanggaran akses
	 */
	public void rename(String newName) throws SecurityException;
	
	/**
	 * Jika model terdefinisi (bukan null), prosedur ini
	 * melakukan update terhadap file tersebut di server.
	 * 
	 * Bisa juga digunakan untuk melakukan refresh terhadap keadaan file
	 * di Server.
	 * 
	 * Sementara ini, asumsikan data user selalu lebih baru dari data server.
	 * Jadi, data user selalu ditimpa.
	 * @throws IOException
	 */
	public void sync() throws IOException;
	
	/**
	 * Melakukan delete file yang sedang di-view
	 * TODO: prioritas kedua
	 */
	public void delete() throws IOException;
}
