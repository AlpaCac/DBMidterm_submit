#java -jar DBMidterm/DBMidterm.jar
sudo docker build -t midterm .
sudo docker run --network=host -p 8080:8080 midterm
