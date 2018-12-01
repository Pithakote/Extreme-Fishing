import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class Main extends PApplet {

//PImage background;
//import processing.sound.*;

/*SoundFile damageSound;
SoundFile screamSound;
SoundFile fishSound;
SoundFile winSound;*/
int screensizex, screensizey, level;
Fish [][] fishes = new Fish [5][5];//declaring the 5x5 2d array of the fishes
Bubbles [][] bubblearray = new Bubbles [5][5];//declaring the 5x5 2d array of the bubbles
Boat boat1;//declaring the object for boat
Fish fishpic;//declaring the object for fish
Fish fishpic1;//declaring another object for fish
IntelligentFish intelligent1;
hook hook1;//declaring the object for hook
shark shark1;//declaring the object for shark
shark shark2;//declaring another object for shark
Bubbles bubblepic;//declaring the object for bubbles
int speedHook=5;//the speed of the Hook
float fishpicx = 200.0f;//declaring the x position for fish
float fishpicy = 400.0f;//declaring the y position for fish
int x=0;
PImage menu;//declaring objects for using images
PImage instruction;
PImage ins;
PImage Underwater;
PImage Island;
PImage end;
int playerHealth = 5;
int score = 0;//initializing the score
public void setup()
{
  level = 1; //by default the stage is 1 i.e the main menu screen is shown
  /* damageSound = new SoundFile(this,"damage.mp3");
  screamSound = new SoundFile(this,"scream.mp3");
  winSound = new SoundFile(this,"win.mp3");
  fishSound = new SoundFile(this,"fish.mp3");*/
  menu = loadImage("splash1.jpg");

  image(menu, 0,0, 800,800);
  
  
  boat1 = new Boat (550,50);
  
  shark1 = new shark(random(50,200),random(800,1050),-10);
  shark2 = new shark(random(50,200),random(800,1050),-10);
  
   
  intelligent1 = new IntelligentFish(random(200,700),random(200,300),0.05f,5);
  
  fishpic1 = new Fish (random(200,700),random(200,800),0.05f,5);
 
  
    for (int rows = 0; rows < fishes.length; rows++)
   {
       for (int columns = 0; columns<fishes.length; columns++)
         {
           fishes[rows][columns] = new Fish (fishpicx,fishpicy,0.05f,2);
           
           bubblearray[rows][columns] = new Bubbles (fishpicx,fishpicy-70);
          fishpicx += 50; //move to next column
         }
     fishpicx = 200.0f;
     fishpicy += 70.0f;
 }
 
  
}


public void draw()
{
  if (level == 1)
  {
   
  menu = loadImage("splash1.jpg");
  save("splash1.jpg");

  image(menu, 0,0, 800,800);
   boat1 = new Boat (550,50);
  
  shark1 = new shark(random(50,200),random(800,1050),-10);
  shark2 = new shark(random(50,200),random(800,1050),-10);
  
   
  intelligent1 = new IntelligentFish(random(200,700),random(200,300),0.05f,5);
  
  fishpic1 = new Fish (random(200,700),random(200,800),0.05f,5);
  
  
    if(key == 'h')
    {
     level = 2;
     Island = loadImage("island.png");
     Island.resize(width,height-650);
     Underwater = loadImage("underwater.jpg");
    Underwater.resize(width,height);  
 }
    if (key == '1')
   {
     exit();
   }
   if (key == 'e')
   {
     level = 3;
       Island = loadImage("island.png");
     Island.resize(width,height-600);
     Underwater = loadImage("underwater.jpg");
    Underwater.resize(width,height-100);  
   }
   
  }

  if(level == 4)
  {
    end = loadImage("tooLate.jpg");
     image(end, 0,0, 800,800);
  size(800,800);
   // stop();
      if (key == '1')
   {
     exit();
   }
   if (key == 'm')
   {
     score = 0;
     playerHealth = 5;
     level = 1;
        
 
   }
  }
  if(level == 5)
  {
     end = loadImage("eaten.jpg");
     image(end, 0,0, 800,800);
  size(800,800);
   // stop();
      if (key == '1')
   {
     exit();
   }
   if (key == 'm')
   {
     score = 0;
     playerHealth = 5;
     level = 1;
         
 
   }
  }
  if(level == 6)
  {
     end = loadImage("endHard.jpg");
     image(end, 0,0, 800,800);
  size(800,800);
 
if (key == '1')
   {
     exit();
   }
   if (key == 'm')
   {
     score = 0;
     playerHealth = 5;
     level = 1;
         
 
   }
  }
  if(level == 7)
  {
     end = loadImage("endEasy.jpg");
     image(end, 0,0, 800,800);
  size(800,800);
 
if (key == '1')
   {
     exit();
   }
   if (key == 'm')
   {
     score = 0;
     playerHealth = 5;
     level = 1;
         
 
   }
     if (key == 'n')
   {
     score = 0;
     playerHealth = 5;
     level = 2;
         
 
   }
  }
  if(level == 3)
  {
    //background(0,206,209);
      drawBackground();
      boat1.update();
      shark1.speedShark = -5;
      shark2.speedShark = -5;
      shark1.update();
      shark2.update();
      intelligent1.update();
      line(0,120,800,120);
  textSize(30);
  fill(0, 102, 153);
  text("Score: "+score, 30,50);//prints the score
  text("Health:" +playerHealth, 30,80);//the health of the player is shown
  for(int rows = 0; rows < fishes.length; rows++)
  {
    for(int columns = 0; columns<fishes.length; columns++)
    {
      fishes[rows][columns].update();//to keep moving the objects one by one
   
      if(fishpicx>width)
  {
    fishpicx = 100;
  }
    }
    
  }
  if(boat1.x+50>=width)
  {
    boat1.x = boat1.x-5;
  }
  else if (boat1.x<=width-800)
  {
    boat1.x = boat1.x+5;
  }
  
  else if (fishpic1.x>width)
  {
    fishpic1.x = -10;
  }
  

   if(hook1 != null)
   {
      hook1.update();
    line(boat1.x+20,boat1.y+70,hook1.x+60,hook1.y);
    hook1.y = hook1.y + speedHook;
    
  }
  if(speedHook == -5)
    {
      if(hook1 != null && hook1.y<boat1.y+70)
           {
             hook1 = null;
             speedHook = 5; 
           }
   }
  
  }


  
  
  if(level == 2)
  {
 
  
    
  drawBackground();
  boat1.update();
  shark1.update();
  shark2.update();
  intelligent1.update();
  line(0,120,800,120);
  textSize(30);
  fill(0, 102, 153);
  text("Score: "+score, 30,50);//prints the score
  text("Health:" +playerHealth, 30,70);//the health of the player is shown
  for(int rows = 0; rows < fishes.length; rows++)
  {
    for(int columns = 0; columns<fishes.length; columns++)
    {
      fishes[rows][columns].update();//to keep moving the objects one by one
      
    bubblearray[rows][columns].update();
      
      if(fishpicx>width)
  {
    fishpicx = 100;
  }
    }
    
  }
  if(boat1.x+50>=width)
  {
    boat1.x = boat1.x-5;
  }
  else if (boat1.x<=width-800)
  {
    boat1.x = boat1.x+5;
  }
  
  else if (fishpic1.x>width)
  {
    fishpic1.x = -10;
  }
  

   if(hook1 != null)
   {
      hook1.update();
    line(boat1.x+20,boat1.y+70,hook1.x+60,hook1.y);
    hook1.y = hook1.y + speedHook;
    
  }
  if(speedHook == -5)
    {
      if(hook1 != null && hook1.y<boat1.y+70)
           {
             hook1 = null;
             speedHook = 5; 
           }
   }
  }

}
  

public void keyPressed()
{
  if(key==CODED)
  {
    if(keyCode == RIGHT )
    {
      boat1.x = boat1.x + 8;
    }
    if(keyCode == LEFT )
    {
      boat1.x = boat1.x - 8;
    }
    if (keyCode == DOWN)
    {
      
      hook1 = new hook(boat1.x+60,boat1.y+100);
    }
    if (keyCode != DOWN)
    {
      
      hook1 = null;
    }
  }
 
}
public void drawBackground() 
{    
    drawIsland();
    drawUnderwater();  
}

public void drawUnderwater()
{
  image(Underwater,x, 120); //draw background twice adjacent
 image(Underwater, x+Underwater.width, 120);
 x -=4;
if(x == -Underwater.width)
 x=0; //wrap background

}

public void drawIsland()
{
   image(Island,x, 0); //draw background twice adjacent
 image(Island, x+Island.width, 0);
 x -=4;
if(x == -Island.width)
 x=0; //wrap background

}
class AquaticCreatures //a super classfor fish and shark sub classes
{
  float x;
  float y;
  
 AquaticCreatures(float x, float y)
  {
   this.x = x;
   this.y = y;
  }
}
class Boat 
{
  int x;
  int y;
  int speedBoat;
  PImage boat_pic,boat_pic1,boat_pic2,boat_pic3,boat_pic4,boat_pic5; //declaring PImage type for using the image
  int boatw = 100; 
  int boath = 75;
  Boat(int x, int y)
  {
    this.x = x;
    this.y = y;
    
    
     boat_pic = loadImage("boat.png");
     boat_pic1 = loadImage("boat1.png");
     boat_pic2 = loadImage("boat2.png");
     boat_pic3 = loadImage("boat3.png");
     boat_pic4 = loadImage("boat4.png");
     boat_pic5 = loadImage("boat5.png");//loading the image if the boat
    boat_pic.resize(boatw,boath);
    boat_pic1.resize(boatw,boath);
    boat_pic2.resize(boatw,boath);
    boat_pic3.resize(boatw,boath);
    boat_pic4.resize(boatw,boath);
    boat_pic5.resize(boatw,boath);//determining the size of the image
  }
  
  public void update()
  {
    move();
    render();
  }
  public void move()
  {
  }
  public void render ()
  {
    if(playerHealth == 5)
    image(boat_pic,x,y);
    else if(playerHealth == 4)
    image(boat_pic1,x,y);
    else if(playerHealth == 3)
    image(boat_pic2,x,y);
    else if(playerHealth == 2)
    image(boat_pic3,x,y);
    else if(playerHealth == 1)
    image(boat_pic4,x,y);
  //  else if (playerHealth < 1)
  //  screamSound.play();
    else{
    image(boat_pic5,x,y);
    }
    //
  }
}
class Bubbles 
{
  float bubblesx;
  float bubblesy;
  
  PImage bubblepic;
  int bubblew = 50;
  int bubbleh = 50;
  
  int appear_bubbles = 0;
  final int BUBBLENOTOUCH = 0; //the values for the game modes when bubbles do not touch the boat
  final int BUBBLETOUCH = 1;//the values for the game modes when bubbles touch the boat
  
  int bubbleGameMode = BUBBLENOTOUCH; //declaring the game Mode
  
  
  Bubbles(float bubblesx, float bubblesy)
  {
    
    this.bubblesx = bubblesx;
    this.bubblesy = bubblesy;
    
     bubblepic = loadImage("bubbles.png");
    bubblepic.resize(bubblew,bubbleh);
   }
   
   public void update()
  {
    move();
    render();
  }
  
  public void move()
  {
    
    //for(float i =0; i<10000; i = random(0,10000))//trying to make bubbles appear in random times
    //{
      bubblesy = bubblesy - 5;//making the bubbles move upward towards the boat
      if(bubbleGameMode==BUBBLENOTOUCH) //when the game starts, the game mode will automatically be 0
    {
      if(crashforbubble1() == true)
      {
        playerHealth = playerHealth - 1;//the player's health decreses by 1 everytime one of the bubbles touch the boat
        if(playerHealth<0)//the series of codes that will be execited if the player's health reaches below zero
        {
        textSize(40);//determining the size if the text
        fill(1,103,154);//the color of the text
        text("DEAD",350,50);//the text that appears with the location
        stop();//the code to stop the game
        
      }
      else
      {//nothing happens if the bubble does not touch the boat
      }
    }
    if (bubblesy <= boat1.y) //when the bubbles touch the boat, the x position of the bubbles will be put outside the screen to make it look like they disappeared
    {
      bubblesx = fishpicx;
      bubblesy = fishpicy-70;
    }
    }
    }

  public boolean crashforbubble1() //the condition when the bubbles touch the boat 
  {
    return (abs(this.bubblesx - boat1.x)<bubblew && abs(bubblesy-boat1.y)<bubbleh);
  }
  public void render()
  {
   //if (appear_bubbles < 20)
    image(bubblepic,bubblesx,bubblesy);
   //else if (appear_bubbles < 40)
   //{} 
   //else if (appear_bubbles < 60)
    image(bubblepic,bubblesx,bubblesy);
   //else if (appear_bubbles < 80)
    {}
    //else 
    //{
      //appear_bubbles = -1;
    //}
    appear_bubbles++;
  
   
  }
   
}
class Fish extends AquaticCreatures //the subclass of the superclass aquatic_creatures
{
 
  float speedX, speedY;
  int animation = 0;
 
  final int NOTOUCH = 0; //the game mode when the fish is not touching the boat
  final int TOUCH = 1;//the game mode when the fish is touching the boat
  
  int gameMode = NOTOUCH; //declaring the game mode as no touch by default
  
  PImage fishpic1,fishpic2,fishpic3,fishpic4; //the PImage Object for loading image
  int fishw = 60; //the width of the fish
  int fishh = 60; //the height of the fish


  Fish(float x, float y, float speedY,float speedX)
  {
    super(x,y);//inhereting the values of x and y of aquatic_creatures
    this.speedY = speedY;
    this.speedX = speedX;
    //this.stepY = stepY;
    
    fishpic1 = loadImage("fish1.png");
    fishpic2 = loadImage("fish2.png");
    fishpic3 = loadImage("fish3.png");
    fishpic4 = loadImage("fish4.png");
    fishpic1.resize(fishw,fishh);
    fishpic2.resize(fishw,fishh);
    fishpic3.resize(fishw,fishh);
    fishpic4.resize(fishw,fishh);
  }
  public void update()//go to tiled rooms
  {
    move();
    render();
  }
  public void move()
  {
    if(gameMode==NOTOUCH)//while the fish is not touching the boat
    {
      x = x + speedX;//moves the fish in the right direction
    float stepY = random(-10,10);//makes the fish move in  a wobbly way
    y = y + stepY;
      if(x >= width)//makes the fish spawn at the left most side of the screen if it exceeds the width of the screen
      {
        x = -10;
      }
      if (y-17<=120)//if the fish reaches the top of the sea, then the game stops and a text saying "Too Late" appears
    {
   // screamSound.play();
    level = 4;
    }
      if(hook1 != null && crashforfishfish() == true) //if the hook touches the fishes, the score 
                                                      //increases and the hook goes back to the boat
      {
       // fishSound.play();
        score = score + 1;//increases the score everytime the hook touches a fish
        speedHook = -5;
       //hook1.y = hook1.y-5;
        
        this.x = -50;
        this.y = 10000;
           
      }
      else
      {
      }
      if(level == 2 && score == 21)
      {
     //   winSound.play();
       level = 6;
      }
       if(level == 3 && score == 21)
      {
      //  winSound.play();
       level = 7;
      }
    }
    
   
  
  }

 public boolean crashforfishfish() 
  {
    return (abs(this.x - hook1.x)<fishw && abs(this.y-hook1.y)<fishh);
  }
  public void render()
  {
    //fill(0,100,100);
    if (animation < 10)
        image(fishpic1,x,y);
    else if (animation < 20)
        image(fishpic2,x,y);
    else if (animation < 30)
        image(fishpic3,x,y);
    else if (animation < 40)
        image(fishpic4,x,y);
      else
      {
        animation = -1;
      }
      animation ++;
    
  }

}
class hook
{
  int x;
  int y;
  int speedY=1;
  
  final int NOTOUCH = 0; //the value of the game mode when the hook is not touching the fish
  final int TOUCH = 1;//the value of the game mode when the hook is touching the fish
  
  int gameMode = NOTOUCH;//by default, the game mode is set to no touch
  
  PImage hook_image;
  int hookw = 100;//the width of the hook
  int hookh = 75;//the height of the hook

  hook(int x, int y)
  {
    this.x =x;
    this.y = y;
    
    hook_image = loadImage("hook.png");
    hook_image.resize(hookw,hookh);
    update();
  }
  public void update()
  {
    move();
    render();
  } 
  public void move()
  {
   
    //when the hook is not touching the fish
    if(gameMode==NOTOUCH)
    { 
      
    
     if(gameMode==NOTOUCH)
    {
      if(crashForFish2() == true) //when the hook touches the fish
                                  
                                 
      {
      //  fishSound.play();
        speedHook = -5;//the hook starts to go up and the
       //hook1.y = hook1.y-5;
        
        fishpic1.x = -50; //fish is moved outside the screen to make it look like it disappeared
        fishpic1.y = 10000;
      }
    else 
    {
      
      
    }
   
   
  }
  if (hook1 != null && hook1.y+70 >= height)
  {
   speedHook = -5; //if the hook goes to the bottom of the screen, it goes back up
  }
    }
  }
 public boolean crashForFish2()
  {
    
    return (abs(this.x - fishpic1.x)<hookw && abs(this.y-fishpic1.y)<hookh);
  }
  
  public void render ()
  {
     image(hook_image,x,y);
  }
}
class IntelligentFish extends AquaticCreatures //the subclass of the superclass aquatic_creatures
{
  
   float speedX, speedY;
  int animation = 0;
 
  float IntelligentStep,IntelligentStepX; 
 
   int IntelligentStepX1 = 0;
   
  final int NOTOUCH = 0; //the game mode when the fish is not touching the boat
  final int TOUCH = 1;//the game mode when the fish is touching the boat
  
  int gameMode = NOTOUCH; //declaring the game mode as no touch by default
  
  float directionX = 10;
  
  PImage intelligent1,intelligent2,intelligent3,intelligent4; //the PImage Object for loading image
  int intelligentfishw = 60; //the width of the fish
  int intelligentfishh = 60; //the height of the fish
  
  IntelligentFish(float x, float y, float speedY,float speedX)
  {
    super(x,y);//inhereting the values of x and y of aquatic_creatures
    this.speedY = speedY;
    this.speedX = speedX;
    //this.stepY = stepY;
    
    intelligent1 = loadImage("anime1.png");
    intelligent2 = loadImage("anime2.png");
    intelligent3 = loadImage("anime3.png");
    intelligent4 = loadImage("anime4.png");
    intelligent1.resize(intelligentfishw,intelligentfishh);
    intelligent2.resize(intelligentfishw,intelligentfishh);
    intelligent3.resize(intelligentfishw,intelligentfishh);
    intelligent4.resize(intelligentfishw,intelligentfishh);
  }
   public void update()//go to tiled rooms
  {
    move();
    render();
  }
   public void move()
  {
    if(gameMode==NOTOUCH)//while the fish is not touching the boat
    {
      x = x + speedX;//moves the fish in the right direction
    float stepY = random(-10,10);//makes the fish move in  a wobbly way
    y = y + stepY;
      if(x >= width)//makes the fish spawn at the left most side of the screen if it exceeds the width of the screen
      {
        x = -10;
      }
    //  if (y-17<=120)//if the fish reaches the top of the sea, then the game stops and a text saying "Too Late" appears
    //{
      //y = 84;
      //speedX = -1;
      //speedY = 0.02;
     // IntelligentStepX1++;
      //if(IntelligentStepX1<10)
      //{
        //x = x - 2;
      //}
      //else if(IntelligentStepX1<10)
      //{
        //x = x + 2;
      //}
      
     // x = x - 2;
      //IntelligentStepX = random(-30,30);
      //x = x - IntelligentStepX;
      
    // IntelligentStep = random(-20,50);
     //y = y + IntelligentStep;
   // }
      if(hook1 != null && crashforfishfish() == true) //if the hook touches the fishes, the score 
                                                      //increases and the hook goes back to the boat
      {
      //  fishSound.play();
        score = score + 1;//increases the score everytime the hook touches a fish
        speedHook = -5;
       //hook1.y = hook1.y-5;
        
        this.x = -50;
        this.y = 10000;
           
      }
      else
      {
      }
      if(level == 2 && score == 21)
      {
        
       level = 6;
      }
       if(level == 3 && score == 21)
      {
        
       level = 7;
      }
    }
    if(crashforfishfishwithboat() == true)//when the shark touches the boat
      {
      //  damageSound.play();
        playerHealth = playerHealth - 1; //the player's health decreases by 1
       // y = random(800,1050);//makes the next spawn of the shark fast or slow
        if(playerHealth<0) // when the health of the player becomes less than 0 due to shark
                           //the text "You Were eaten appears"
        {
         level = 5;
        
       }
      }
      else
      {
      }
   
  
  }

 public boolean crashforfishfish() 
  {
    return (abs(this.x - hook1.x)<intelligentfishw && abs(this.y-hook1.y)<intelligentfishh);
  }
  public boolean crashforfishfishwithboat() 
  {
    return (abs(this.x - boat1.x)<intelligentfishw && abs(this.y-boat1.y)<intelligentfishh);
  }
  public void render()
  {
     if (y-17<=120)//if the fish reaches the top of the sea, then the game stops and a text saying "Too Late" appears
    {
      y = 84;
      speedX = 5;
      //speedY = 0.02;
     
      if(IntelligentStepX1<10)
      {
        x = x + speedX;
      }
      else if(IntelligentStepX1<20)
      {
        speedX = -5;
        x = x + speedX;
      }
      else 
      {
        IntelligentStepX1 = 0;
      }
      
       IntelligentStepX1++;
       println("SpeedX: "+speedX);
      println("Counter: "+IntelligentStepX1);
     // x = x - 2;
      //IntelligentStepX = random(-30,30);
      //x = x - IntelligentStepX;
      
    // IntelligentStep = random(-20,50);
     //y = y + IntelligentStep;
    }
    //fill(0,100,100);
    if (animation < 10)
        image(intelligent1,x,y);
    else if (animation < 20)
        image(intelligent2,x,y);
    else if (animation < 30)
        image(intelligent3,x,y);
    else if (animation < 40)
        image(intelligent4,x,y);
      else
      {
        animation = -1;
      }
      animation ++;
    
  }
}
class shark extends AquaticCreatures//the shark class is the subclass of the superclass aquatic_creatures
{
  float sharkx ;
  float sharky ;
  
  PImage shark_image;
  int sharkw = 100;
  int sharkh = 200;
  int speedShark  ;
 
 
  shark(float x, float y, int speedShark)
  {
    super(x,y);//inhereting the values of x and y from superclass aquatic_creatures
    this.speedShark = speedShark;
    shark_image = loadImage("shark.png");
    shark_image.resize(sharkw,sharkh);
    update();
  }
  
  public void update()
  {
    move();
    render();
  }
  
  public void move()
  {
   
     y = y + speedShark;
      if (y<=120)
    {
      y = random(800,1050);//makes the spawn of the shark late or quick 
      x = random(0,800);//makes the shark appear from random x position
    }                    
       if(crashforshark() == true)//when the shark touches the boat
      {
      //  damageSound.play();
        playerHealth = playerHealth - 1; //the player's health decreases by 1
        y = random(800,1050);//makes the next spawn of the shark fast or slow
        if(playerHealth<0) // when the health of the player becomes less than 0 due to shark
                           //the text "You Were eaten appears"
        {
         level = 5;
        
       }
      }
      else
      {
      }
   
}
 public boolean crashforshark()
  {
    return (abs(this.x - boat1.x)<sharkw && abs(y+110-boat1.y)<sharkh);
  } 
  public void render()
  {
    image(shark_image,x,y);
  }
}
  public void settings() {  size(800,800); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "Main" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
