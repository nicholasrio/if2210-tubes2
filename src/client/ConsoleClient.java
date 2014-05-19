/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import Client.Client;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 *
 * @author Gilang
 */
public class ConsoleClient extends Client {

	public ConsoleClient(String host, int port) {
		super(host, port);
	}

	public static void main(String[] args) {
		ConsoleClient client = new ConsoleClient("localhost", 5432);
		client.run();
	}

	private void run() {
		try {
			do {

				reader = new BufferedReader(new InputStreamReader(System.in));
				if (!LoggedIn) {
					System.out.println("1. login");
				} else {
					System.out.println("1. logout");
				}
				System.out.println("2. upload");
				System.out.println("3. print");
				System.out.println("4. exit");
				input = reader.readLine();
				if (input.equals("login") && !LoggedIn) {
					login();
				} else if (input.equals("upload")) {
					sendFile();
				} else if (input.equals("print")) {
					printRequest();
				} else if (input.equals("logout") && LoggedIn) {
					logout();
				}
			} while (!input.equals("exit"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void login() {
		try {
			System.out.println("Enter NIM: ");
			NIM = reader.readLine();
			System.out.println("Enter password: ");
			password = reader.readLine();
			super.login(NIM, password);
			System.out.println("Username: " + userData.getUsername());
			System.out.println("Name: " + userData.getNama());
			System.out.println("E-mail: " + userData.getEmail());
			System.out.println("Saldo: " + userData.getSaldo());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void printRequest() {
		System.out.println("Input filename: ");
		try {
			super.printRequest(reader.readLine());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void sendFile() {
		System.out.println("Masukkan path file yang akan diupload: ");
		try {
			String filePath = reader.readLine();
			super.sendFile(filePath);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void sendResponse(){
		try{
			String response = reader.readLine();
			super.sendResponse(response);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
// test
