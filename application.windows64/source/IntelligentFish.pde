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
   void update()//go to tiled rooms
  {
    move();
    render();
  }
   void move()
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

 boolean crashforfishfish() 
  {
    return (abs(this.x - hook1.x)<intelligentfishw && abs(this.y-hook1.y)<intelligentfishh);
  }
  boolean crashforfishfishwithboat() 
  {
    return (abs(this.x - boat1.x)<intelligentfishw && abs(this.y-boat1.y)<intelligentfishh);
  }
  void render()
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
