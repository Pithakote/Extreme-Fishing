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
   
   void update()
  {
    move();
    render();
  }
  
  void move()
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

  boolean crashforbubble1() //the condition when the bubbles touch the boat 
  {
    return (abs(this.bubblesx - boat1.x)<bubblew && abs(bubblesy-boat1.y)<bubbleh);
  }
  void render()
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
