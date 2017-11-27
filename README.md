# F5: Third Year Project; SYSC 3010
This README file is for the Flareon Flame System put together for the SYSC 3010 project created by Group F5*(Shaviyo Marasinghe, 
Brian Ranjan, Ezwad Rahman, Raj Waidyaratna)*


## [Arduino(Kuman) UNO](https://github.com/ilhamrahman/F5/blob/master/Arduino/temperatureArduino.ino)
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
###### Sunfounder Flame Sensor

## Raspberry Pi1: Data Collection Unit (DCU)
###### [Data Collection Class](https://github.com/ilhamrahman/F5/blob/master/DCU/src/DataCollectionClass.java)
###### [Sender](https://github.com/ilhamrahman/F5/blob/master/DCU/src/Sender.java)

## Raspberry Pi1: Data Collection Unit (DHU)
###### [Receiver](https://github.com/ilhamrahman/F5/blob/master/DHU/src/Receiver.java)
###### [Data Analysis Class](https://github.com/ilhamrahman/F5/blob/master/DHU/src/DataAnalysis.java)
###### [Sender](https://github.com/ilhamrahman/F5/blob/master/DHU/src/Sender.java)

## Android Application
###### [FFS_APP](https://github.com/ilhamrahman/F5/tree/master/FFS_app)
