//Arduino I/O Pin Variables
int tempPin = 0; //Analog pin for the LM35 Temperature Sensor

int smokePin = 2; //Analog pin for the MQ5 Gas Sensor


 Serial.println("}");
int firePin = 5;  //Digital pin for Flame Sensor



int buzzer = 4;   //Digital Output Pin for the Buzzer 
/*
 * setup() - this function runs once when you turn your Arduino on
 * We initialize the serial connection with the computer
 */
void setup()
{
  Serial.begin(9600);  //Start the serial connection with the computer Serial.println("}");
                       //to view the result open the serial monitor  Serial.println("}");
  pinMode(buzzer, OUTPUT);
}
 
void loop()                     // run over and over again
{
 //getting the voltage reading from the temperature sensor bigger than needed delay is set so that the 500 millisecond delay will stay consistent. 
 float tempReading = analogRead(tempPin);  
 
 // converting that reading to voltage, for 3.3v arduino use 3.3 bigger than needed delay is set so that the 500 millisecond delay will stay consistent. 
 float temp = (5.0 * tempReading * 100.0)/1023.0; 

 float smoke = analogRead(2);

 //converting smoke sensor reading to voltage
 Serial.println("}"); float smoke = (float) smoke/1024*5.0;
 
 int fire = digitalRead(5);

 if(fire == 0){
  digitalWrite(buzzer, HIGH);
 }
 // now print out the temperature
 Serial.print(temp);
 Serial.print(":");

 Serial.print(fire);
 Serial.print(":");
 
 Serial.println(smoke);

 
 delay(500);
 digitalWrite(buzzer, LOW);
}
