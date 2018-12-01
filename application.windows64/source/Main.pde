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
float fishpicx = 200.0;//declaring the x position for fish
float fishpicy = 400.0;//declaring the y position for fish
int x=0;
PImage menu;//declaring objects for using images
PImage instruction;
PImage ins;
PImage Underwater;
PImage Island;
PImage end;
int playerHealth = 5;
int score = 0;//initializing the score
void setup()
{
  level = 1; //by default the stage is 1 i.e the main menu screen is shown
  /* damageSound = new SoundFile(this,"damage.mp3");
  screamSound = new SoundFile(this,"scream.mp3");
  winSound = new SoundFile(this,"win.mp3");
  fishSound = new SoundFile(this,"fish.mp3");*/
  menu = loadImage("splash1.jpg");

  image(menu, 0,0, 800,800);
  size(800,800);
  
  boat1 = new Boat (550,50);
  
  shark1 = new shark(random(50,200),random(800,1050),-10);
  shark2 = new shark(random(50,200),random(800,1050),-10);
  
   
  intelligent1 = new IntelligentFish(random(200,700),random(200,300),0.05,5);
  
  fishpic1 = new Fish (random(200,700),random(200,800),0.05,5);
 
  
    for (int rows = 0; rows < fishes.length; rows++)
   {
       for (int columns = 0; columns<fishes.length; columns++)
         {
           fishes[rows][columns] = new Fish (fishpicx,fishpicy,0.05,2);
           
           bubblearray[rows][columns] = new Bubbles (fishpicx,fishpicy-70);
          fishpicx += 50; //move to next column
         }
     fishpicx = 200.0;
     fishpicy += 70.0;
 }
 
  
}


void draw()
{
  if (level == 1)
  {
   
  menu = loadImage("splash1.jpg");
  save("splash1.jpg");

  image(menu, 0,0, 800,800);
   boat1 = new Boat (550,50);
  
  shark1 = new shark(random(50,200),random(800,1050),-10);
  shark2 = new shark(random(50,200),random(800,1050),-10);
  
   
  intelligent1 = new IntelligentFish(random(200,700),random(200,300),0.05,5);
  
  fishpic1 = new Fish (random(200,700),random(200,800),0.05,5);
  
  
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
  

void keyPressed()
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
void drawBackground() 
{    
    drawIsland();
    drawUnderwater();  
}

void drawUnderwater()
{
  image(Underwater,x, 120); //draw background twice adjacent
 image(Underwater, x+Underwater.width, 120);
 x -=4;
if(x == -Underwater.width)
 x=0; //wrap background

}

void drawIsland()
{
   image(Island,x, 0); //draw background twice adjacent
 image(Island, x+Island.width, 0);
 x -=4;
if(x == -Island.width)
 x=0; //wrap background

}
