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

 boolean crashforfishfish() 
  {
    return (abs(this.x - hook1.x)<fishw && abs(this.y-hook1.y)<fishh);
  }
  void render()
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
