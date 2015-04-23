int lmPin = A0;
int photoPin = A1;
int irPin = A2;
void setup() {
  // put your setup code here, to run once:
  Serial.begin(9600);
}
int light(){
  int x = analogRead(photoPin);
  return x;
}

int ir(){
  int x = analogRead(irPin);
  return x;
}

float tempC(){
  float raw =                 analogRead(lmPin);
  //return ((raw * 5.0 / 1024.0 ) - 0.5 ) * 10;
//  
  //float percent = raw / 1023.0;
  //float volts = percent;
  //return 100.0 * volts;
  return raw;
}
void loop() {
  // put your main code here, to run repeatedly:
  Serial.print("T:");
  Serial.println(tempC());
  Serial.print("L:");
  Serial.println(light());
  Serial.print("IR:");
  Serial.println(ir());
  delay(1000);
}
