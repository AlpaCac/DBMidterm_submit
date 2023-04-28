#!/bin/bash

DB_URL="http://localhost:8080/api/v1"
TABLE_NAME="dept_manager"
FILE_PATH="/root/dept_manager.csv"
#FILE_PATH=$(readlink -f dept_manager.csv)

curl -X POST -H "Content-Type: application/json"  "$DB_URL/$TABLE_NAME/insertCsv?filePath=$FILE_PATH"
