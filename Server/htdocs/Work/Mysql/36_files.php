<?php
/*
 Our Today's Topics is File 
i.fgetc()//fgetc function character by character read kore
ii.fgets() // fgets function line by line read kore
This 2 function work

*/
 $fptr=fopen("pan.txt","r");
//  echo fgets($fptr);

echo fgets($fptr);

while($a=fgetc($fptr)){
    echo $a;
}

?>