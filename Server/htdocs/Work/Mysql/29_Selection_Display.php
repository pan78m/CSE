<?php
//Create Databases using sql command

$servername = "localhost";
$username = "root";
$password = "";
$dbn = "Pan";

//connection to database
$conn = mysqli_connect($servername, $username, $password, $dbn);
if (!$conn) {
    die("Could not connect mysql->" . mysqli_connect_error());
} else {
    echo "Connected Successfully to Database<br/>";
}
//Select Record from the table
$sql = "SELECT * FROM `tp`";
//Do not create same name table in db.
$result = mysqli_query($conn, $sql);
// Find the total number of record in the table
$num = mysqli_num_rows($result);
echo $num. " Total No.of record found "."<br/>";

// Display the all records
/*
 if($num>0){
    // record return 1 by 1 this mysqli_fetch_assoc() method
    $row=mysqli_fetch_assoc($result);
    echo var_dump($row)."<br/>";
    $row=mysqli_fetch_assoc($result);
    echo var_dump($row)."<br/>";
    $row=mysqli_fetch_assoc($result);
    echo var_dump($row)."<br/>";
    $row=mysqli_fetch_assoc($result);
    echo var_dump($row)."<br/>";
    $row=mysqli_fetch_assoc($result);
    echo var_dump($row)."<br/>";
    $row=mysqli_fetch_assoc($result);
    echo var_dump($row)."<br/>";
    $row=mysqli_fetch_assoc($result);
    echo var_dump($row)."<br/>";
 }
if($result){
    echo "Record Insert Successfull<br/>";   
   }else{
       echo "Record Insert Failed---->".mysqli_error($conn);
   }
   mysqli_close($conn);
*/
// Use a better way Display all the record using while loop
// loop cholbe totokhon jotokhon nah result aar value Null nah hoy
if ($num > 0) {
    while ($row = mysqli_fetch_assoc($result)) {
         echo var_dump($row)."<br/>";
        //echo $row["sno"] . " Hello " . $row["name"] . " Coming from " . $row["des"] . "<br/>";
    }
}


?>