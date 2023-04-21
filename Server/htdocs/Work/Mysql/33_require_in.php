<?php
//What is the means of Required and Include in php
 // include jodi database wrong o thake than tarpor oo eta kaj kore 
 // mane holo program chole just warning dia porer kaj kore

 //include '_dbconnection.php';

 // required kono vulbal database name dile program run kore nah 
 // fatal error dey mane program oi line e end hoye jay jekhane error pay
 // okhane.
 require '_dbconnection.php';
 echo "This<br/>";

//Select Record from the table
$sql = "SELECT * FROM `tp`";
//Do not create same name table in db.
$result = mysqli_query($conn, $sql);
// Find the total number of record in the table
$num = mysqli_num_rows($result);
echo $num. " Total No.of record found "."<br/>";

if ($num > 0) {
    while ($row = mysqli_fetch_assoc($result)) {
        //echo var_dump($row)."<br/>";
        echo $row["sno"] . ". Hello " . $row["name"] . " Welcome " . $row["des"] . "<br/>";
        
    }
}

?>