int lmPin = A0;
int photoPin = A1;
int airPin1 = A4;
int airPin2 = A5;

void setup() {
  Serial.begin(9600);
}
int light(){
  int x = analogRead(photoPin);
  return x;
}

float tempC(){
  float raw =                 analogRead(lmPin);
  float percent = raw / 1023.0;
  float volts = percent;
  return 100.0 * volts;
}
void loop() {
  // put your main code here, to run repeatedly:
  Serial.print("/T:");
  Serial.print(tempC());
  Serial.print("/L:");
  Serial.print(light());
  Serial.print("/A1:");
  Serial.print(analogRead(airPin1));
  Serial.print("/A2:");
  Serial.println(analogRead(airPin2));
  delay(1000);
}
