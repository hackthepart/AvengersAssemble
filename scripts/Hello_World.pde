//LANGUAGE : Processing
//AUTHOR: Himanshu Kumar Gautam
//GITHUB: https://github.com/hgautam2010

Mover[] move;
spring[] springs;
int pend;
PFont f;
String s;
void setup()
{
  size(1080, 720);
  s = "Hello World!";
  f = createFont("AmericanTypewriter",74);
  textFont(f);
  textSize(74);
  pend = 12;
  move = new Mover[pend];
  springs = new spring[pend];
  int x, i;
  x = 0;
  for (i = 0; i < s.length(); ++i)
  {
    x += 83;
    springs[i] = new spring(x);
    move[i] = new Mover(x, random(200,400), s.charAt(i));
  }
  pend = i;
}
void draw()
{
  background(255);
  stroke(0);
  strokeWeight(5);
  for (int i = 0; i < pend; i++)
  {
    if(i == 5)
      continue;
    spring s = springs[i];
    Mover m = move[i];
    line(s.origin.x, s.origin.y, m.loc.x, m.loc.y - m.mass*10);
    PVector vect = s.calculateForce(m);
    m.applyForce(vect);
    m.applyForce(new PVector(0,0.1));
    m.update();
    m.display();
  }
}
class Mover
{
  PVector loc, aVel, aAce;
  float mass;
  float r,g,b;
  String s;
  Mover(float x, float y, char ss)
  {
    loc = new PVector(x, y);
    aVel = new PVector(0, 0);
    aAce = new PVector(0, 0);
    mass = 3;
    r = 231;
    g = 43;
    b = 103;
    s = ss+"";
  }
  void applyForce(PVector force)
  {
    PVector f = PVector.div(force, mass*10);
    aAce.add(f);
  }
  void update()
  {
    aVel.add(aAce);
    loc.add(aVel);
    aAce.mult(0);
  }
  void display()
  {
    fill(r,g,b);
    pushMatrix();
    translate(loc.x - textWidth(s.charAt(0))/2,loc.y + (textDescent() + textAscent())/2 );
    text(s,0,0);
    popMatrix();
  }
}
class spring
{
  PVector origin;
  float restLength, k;
  spring(float x)
  {
    origin = new PVector(x,0);
    restLength = 300;
    k = -0.05;
  }
  PVector calculateForce(Mover m)
  {
    PVector vect = PVector.sub(m.loc, origin);
    float currentLength = vect.mag();
    vect.normalize();
    float stretch = currentLength - restLength;
    vect.mult(k * stretch);
    return vect;
  }
}