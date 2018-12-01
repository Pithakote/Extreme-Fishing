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
  void update()
  {
    move();
    render();
  } 
  void move()
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
 boolean crashForFish2()
  {
    
    return (abs(this.x - fishpic1.x)<hookw && abs(this.y-fishpic1.y)<hookh);
  }
  
  void render ()
  {
     image(hook_image,x,y);
  }
}
