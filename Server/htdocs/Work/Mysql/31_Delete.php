<?php 

$servername="localhost";
$username="root";
$password="";
$dbn="Pan";

//connection to database
$conn=mysqli_connect($servername,$username,$password,$dbn);
if(!$conn){
    die("Could not connect mysql->".mysqli_connect_error());
}else{
 echo "Connected Successfully to Database<br/>";   
}
// Delete Data From Databases Tables

$sql="DELETE FROM `tp` WHERE `des`='Ban' LIMIT 5";// If i delete limit value then i will use LIMIT Clause
try {
    $result = mysqli_query($conn, $sql);
    // Find the total number of record in the table
    //echo var_dump($result);
    $aff = mysqli_affected_rows($conn);
    echo "<br/>Number of affected rows: $aff <br/>";
    if ($result) {
        echo "We Delete the record Successfully";
    } else {
        echo "We could not Delete the record successfully";
    }
} catch (Exception $e) {
    echo "We could not Delete the record successfully because->>".$e->getMessage();
}

?>