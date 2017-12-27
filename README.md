# F5: Third Year Project; SYSC 3010
This README file is for the Flareon Flame System put together for the SYSC 3010 project created by Group F5
*(Shaviyo Marasinghe, Brian Ranjan, Ezwad Rahman, Raj Waidyaratna)*


## [Arduino(Kuman) UNO](https://github.com/ilhamrahman/F5/blob/master/Arduino/temperatureArduino/temperatureArduino.ino)
###### LM35 Temperature Sensor
The Temperature Sensor used on this project is the LM35 Temperature Sensor that comes default with the Kuman kit for the
Arduino Uno. This Sensor is an Analog Sensor that outputs it's value in millivolts. It is converted to Degrees Celcius
by following the formula; (5.0 * Reading_in_Millivolts * 100.0) * 1023.0 this was taken directly from the LM35 Datasheet.
The Arduino's Analog Pin 0 will be used. 

The Three Pins of the LM35 are as follows: 

- Pin0: Voltage In

- Pin1: Analog Out

- Pin2: Ground


###### MQ5 Smoke Sensor
The MQ5 Smoke Sensor was used in this Project. This smoke sensor's output is an alaog output and it is converted to "Usable values" by deciphering that resistance value as well. In the MQ5, the user must set a certain threshold ratio to get the concentration of gas in the atmosphere. In our project's context, this would be calibrated to detect carbon monoxide concentration in the user's household. 

The Three Pins of the MQ5 are Color coded and are as follows:

- PinRed: Voltage In

- PinYellow: Analog Out

- PinBlack: Ground


###### Sunfounder Flame Sensor
The Sunfounder Flame Sensor contains both an analog output and a digital output. For the purpose of this project, the digital output was used to determine if a fire was present within the Sensor's proximity. This signal was then sent through the Arduino to the other devices to be used in the system. 

The Three Pins of the Flame Sensor are Color coded and are as follows:

- PinRed: Voltage In

- PinBrown: Digital Out

- PinBlack: Ground


## Raspberry Pi1: Data Collection Unit (DCU)
###### [Data Collection Class](https://github.com/ilhamrahman/F5/blob/master/DCU/src/DataCollectionClass.java)
Java Class in charge of gathering information from the arduino UNO microprocessor. This class will acess the serial port of the RPi using the JSerialComm library. This Class recieves the raw data from the microprocessor which it will convert to usable data in degrees celcius, fire status, and smoke status for the temperature sensor, flame sensor, and smoke sensor respectively. 
###### [Sender](https://github.com/ilhamrahman/F5/blob/master/DCU/src/Sender.java)

## Raspberry Pi2: Data Handling Unit (DHU)
###### [Receiver](https://github.com/ilhamrahman/F5/blob/master/DHU/src/Receiver.java)
###### [Data Analysis Class](https://github.com/ilhamrahman/F5/blob/master/DHU/src/DataAnalysis.java)
###### [Sender](https://github.com/ilhamrahman/F5/blob/master/DHU/src/Sender.java)
###### [Database](https://github.com/ilhamrahman/F5/blob/master/DHU/src/Database.java)

## Android Application
###### [FFS_APP](https://github.com/ilhamrahman/F5/tree/master/FFS_app)
