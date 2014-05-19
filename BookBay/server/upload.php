<?php
$check = isset($_POST["File-Uploader"]) && !empty($_POST["File-Uploader"]) &&
		 isset($_POST["File-Name"]) && !empty($_POST["File-Name"]) &&
		 isset($_POST["File-Category"]) && !empty($_POST["File-Category"]) &&
		 isset($_POST["File-Desc"]) && !empty($_POST["File-Desc"]) &&
		 isset($_FILES["file"]);

if (!$check) {
	header('HTTP/1.1 406 Not Acceptable');
	die("Error: incomplete POST information!");
}

// error
if ($_FILES["file"]["error"] > 0) {
	echo "Error ".$_FILES["file"]["error"]."<br />";
	header('HTTP', true, 500);
} else {
	// TODO: Sanitize input
	$fileUploader = $_POST["File-Uploader"];
	$fileName = $_POST["File-Name"];
	$fileCategory = $_POST["File-Category"];
	$fileDescription = $_POST["File-Desc"];

	// invoke SQL
	$db = "bookbay";
	$host = "localhost";
	$username = "root";
	$password = "";

	$mysqli = new mysqli($host, $username, $password, $db);
	$thread = $mysqli->thread_id;

	if($mysqli->connect_errno) {
		printf("DB connection failed: %s\n", $mysqli->connect_error);
		header('HTTP/1.1 503 Service Unavailable');
		exit;
	}

	// check the user first
	$queryCheckUser = "SELECT id FROM user WHERE username='".$fileUploader."'";
	$userID = NULL;

	if($result = $mysqli->query($queryCheckUser, MYSQLI_USE_RESULT)) {
		$userID = $result->fetch_object()->id;

		echo 'Uploader id: '.$userID.'<br />';
		$result->free();
	} else {
		header('HTTP/1.1 500 Internal Server Error');
		die("DB error: ".$mysqli->sqlstate);
	}

	// pasang lokasinya
	$dir = "/upload/".$fileUploader."/";
	$upload_dir = realpath(dirname(__FILE__)).$dir;

	// buat direktori
	if(!file_exists($upload_dir)) {
		if(mkdir($upload_dir, 0777, true)) {
			echo "Created user directory for ".$fileUploader."<br />";
		} else {
			header('HTTP', true, 500);
			$mysqli->close();
			die ("Directory creation failed");
		}
	}
	
	// hash the filename
	$fileNameHash = sha1_file($_FILES["file"]["tmp_name"]).".".pathinfo($_FILES["file"]["name"], PATHINFO_EXTENSION);
	$dest = $upload_dir.$fileNameHash;

	// pindahin filenya
	$retval = NULL;
	if(file_exists($dest)) {
		$mysqli->close();
		die("File has been uploaded before!");
	} else {
		$retval = move_uploaded_file($_FILES["file"]["tmp_name"], $dest);
	}

	if(!$retval || is_null($retval)) {
		echo "Upload failed.<br />";
	} else {
		assert(!is_null($userID));

		// tambahin entry ke database
		$location = $dir.$fileNameHash;
		$queryInsert = "INSERT INTO book (name, location, uploader_id, description, category) 
						VALUES ('".$fileName."','".$location."',".$userID.",'".$fileDescription."','".$fileCategory."');";
		$queryInsert .= "INSERT INTO user_book (user_id, book_id) VALUES (
						".$userID.",(SELECT id FROM book WHERE name='".$fileName."'));";

		// NOTE: ini ngga butuh di-free, soalnya INSERT statement cuma nge-return true/false
		if($mysqli->multi_query($queryInsert)) {
			do {
				$mysqli->use_result();
				$mysqli->next_result();
			} while($mysqli->more_results() && !$mysqli->errno);

			if($mysqli->errno) {
				echo "Error: ".$mysqli->error."<br />";
				header("HTTP/1.1 500 Internal server error");
				unlink($dest);
			} else {
				echo 'Book updated.'."<br />";
				echo "File saved to ".$dest."<br />";
			}
		} else {
			unlink($dest);
			echo "Database error: ".$mysqli->error;
			header("HTTP/1.1 500 Internal server error");
		}
	}

	$mysqli->close();
}

?>