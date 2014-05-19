<?php

$checkHeader = isset($_POST['File-Name']) && !empty($_POST['File-Name']) &&
			   isset($_POST['User-Name']) && !empty($_POST['User-Name']);

if(!$checkHeader) {
	header('HTTP/1.1 406 Not Acceptable');
	echo "Error: Incomplete POST information";
} else {
	// TODO: pindahin dong~
	$db = "bookbay";
	$host = "localhost";
	$username = "root";
	$password = "";

	$mysqli = new mysqli($host, $username, $password, $db);

	if($mysqli->connect_errno) {
		printf("Connect failed: %s\n", $mysqli->connect_error);
		header('HTTP/1.1 503 Service Unavailable');
		exit;
	}

	if(!$mysqli->set_charset("utf8")) {
		echo "Error setting charset!";
	}

	// filter
	$fileName = str_replace(PHP_EOL, NULL, $mysqli->real_escape_string($_POST['File-Name']));
	$fileName = str_replace("\\r\\n", NULL, $fileName);
	$fileName = str_replace("\\n", NULL, $fileName);
	$userName = str_replace(PHP_EOL, NULL, $mysqli->real_escape_string($_POST['User-Name']));
	$userName = str_replace("\\r\\n", NULL, $userName);
	$userName = str_replace("\\n", NULL, $userName);

	// TODO: nanti jadiin fungsi sendiri di MySQL
	$query = "SELECT * FROM book WHERE id=".
			 "(SELECT book_id FROM user_book WHERE user_id=".
			 	"(SELECT id FROM user WHERE username='".$userName."')".
			 ") AND name='".$fileName."';";
	
	// do download
	$location = NULL;
	if($result = $mysqli->query($query, MYSQLI_USE_RESULT)) {
		$location = $result->fetch_object()->location;

		echo "Target file: ".$location."<br />";

		$result->free();
	} else {
		echo "Database error: ".$mysqli->error."<br />";
		header('HTTP 500 Internal Server Error');
	}
	$mysqli->close();

	// anggap ngga ada filenya
	if(is_null($location)) {
		header('HTTP/1.1 404 File Not Found');
		die ("File not found!");
	}
	$realFileLocation = realpath(dirname(__FILE__)).$location;

	// header untuk download file
	header('Content-Disposition: attachment; filename='.$realFileLocation);
	header('Content-Type: application/pdf'); // TODO: dibuat jadi universal
	header('Expires: 0');
	header('Cache-Control: must-revalidate');
	header('Content-Transfer-Encoding: binary');
	header('Content-Length: '.filesize($realFileLocation));
	header('Pragma: public');

	ob_clean();
	flush();

	// download!
	// TODO: ini fungsi cacad sebenernya.. coba cari fungsi lain
	readfile($realFileLocation);
}
?>