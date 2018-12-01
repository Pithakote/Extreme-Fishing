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
  
  void update()
  {
    move();
    render();
  }
  void move()
  {
  }
  void render ()
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
