#!/bin/bash

DB_URL="http://localhost:8080/api/v1"
TABLE_NAME="departments"
FILE_PATH="/root/departments.csv"

curl -X POST -H "Content-Type: application/json"  "$DB_URL/$TABLE_NAME/insertCsv?filePath=$FILE_PATH"
