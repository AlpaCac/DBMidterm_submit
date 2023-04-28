#!/bin/bash

DB_URL="http://localhost:8080/api/v1"
TABLE_NAME="dept_emp"
FILE_PATH="/root/dept_emp.csv"
#FILE_PATH=$(readlink -f dept_emp.csv)

curl -X POST -H "Content-Type: application/json"  "$DB_URL/$TABLE_NAME/insertCsv?filePath=$FILE_PATH"
