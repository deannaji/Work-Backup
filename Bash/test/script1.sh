#!/bin/bash
 
read -p "Please enter filename: " filename
read -p "Please enter the year(yyyy): " year

MONTHS=(ZERO Jan Feb Mar Apr May Jun Jul Aug Sep Oct Nov Dec)

if [ -f $filename ]; then	

  for ((i=1; i< ${#MONTHS[@]}; i++));
  do 
     $(mkdir ${MONTHS[$i]})
     daysNum=31

     if  [ "${MONTHS[$i]}" == "Feb" ]; then
       daysNum=29

     elif [ "${MONTHS[$i]}" == "Apr" ] || [ "${MONTHS[$i]}" == "Jun" ] || [ "${MONTHS[$i]}" == "Sep" ] || [ "${MONTHS[$i]}" == "Nov" ]; then  
       daysNum=30 
     fi	   
 
     for ((j=01; j<= $daysNum ; j++));
     do
         cp $filename "${MONTHS[$i]}/test-${MONTHS[$i]}-$j-$year.txt"
     done	
  done

else
   echo "Error: File is not found."
   exit 
fi
