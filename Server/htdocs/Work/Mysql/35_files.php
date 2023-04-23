<?php
/*
 Our Today's Topics is File 
 i.fopen()
 ii.fclose()
 iii.fread()

*/
// fopen function 2 ta parameter nay prothom ta holo file name jeta read korbo oiter name and second holo mood
$fptr=fopen("pan.txt","r");
//echo $fptr;
if(!$fptr){
    die("Unable the file you write down the valid file name");
}
//fread function oo 2 ta paprameter nay prothom ta holo file pointer second ta holo filesize ar file size o ekta function jar parameter hishabe ney oi main file er nam
 $content=fread($fptr,filesize("pan.txt"));
 fclose($fptr);
 echo $content;

?>