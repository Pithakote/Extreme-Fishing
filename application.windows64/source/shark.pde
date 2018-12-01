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
  
  void update()
  {
    move();
    render();
  }
  
  void move()
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
 boolean crashforshark()
  {
    return (abs(this.x - boat1.x)<sharkw && abs(y+110-boat1.y)<sharkh);
  } 
  void render()
  {
    image(shark_image,x,y);
  }
}
