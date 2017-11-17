//TMP35 Pin Variables
int tempPin = 0; //the analog pin the TMP36's Vout (sense) pin is connected to
                        //the resolution is 10 mV / degree centigrade with a
                        //500 mV offset to allow for negative temperatures

int smokePin = 2; //Analog pin for the Octopus Gas Sensor



int firePin = 5;  //Digital pin for Flame Sensor



int buzzer = 4; 
/*
 * setup() - this function runs once when you turn your Arduino on
 * We initialize the serial connection with the computer
 */
void setup()
{
  Serial.begin(9600);  //Start the serial connection with the computer
                       //to view the result open the serial monitor 
  pinMode(buzzer, OUTPUT);
}
 
void loop()                     // run over and over again
{
 //getting the voltage reading from the temperature sensor
 float tempReading = analogRead(tempPin);  
 
 // converting that reading to voltage, for 3.3v arduino use 3.3
 float temp = (5.0 * tempReading * 100.0)/1023.0; 

 float smoke = analogRead(2);
 int fire = digitalRead(5);

 if(fire == 0){
  digitalWrite(buzzer, HIGH);
 }
 // now print out the temperature
 Serial.print("{");
 Serial.print(temp);
 Serial.print(":");

 Serial.print(fire);
 Serial.print(":");
 
 Serial.print(smoke);
 Serial.println("}");

 
 delay(500);
 digitalWrite(buzzer, LOW);
}
