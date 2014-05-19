package com.data;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Time;

/**
 *
 * @author Luthfi Hamid Masykuri / 13512100
 */
public class UserLog {

	private int ID;
	private Date Tanggal;
	private Time Waktu;
	private int Debet;
	private int Kuota;

	public UserLog(int Debet, int Kuota) {
		this.ID = 0;
		java.util.Calendar cal = java.util.Calendar.getInstance();
		java.util.Date utilDate = cal.getTime();
		this.Tanggal = new Date(utilDate.getDate());
		this.Waktu = new Time(utilDate.getTime());
		this.Debet = Debet;
		this.Kuota = Kuota;
	}

	public UserLog(ResultSet Data) {
		try {
			ID = Data.getInt("id");
			Tanggal = Data.getDate("tanggal");
			Waktu = Data.getTime("waktu");
			Debet = Data.getInt("debet");
			Kuota = Data.getInt("kuota");
		} catch (Exception e) {

		}
	}

	public int getID() {
		return ID;
	}

	public Date getDate() {
		return Tanggal;
	}

	public Time getTime() {
		return Waktu;
	}

	public int getDebet() {
		return Debet;
	}

	public int getKuota() {
		return Kuota;
	}
}
