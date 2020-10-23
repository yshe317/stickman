To run the game:
$gradle run

JSON file format:
the levels are list in the biggest list in jsonfile, for each levelstructure of level,
levelsize means the size of level,
stickmansize can be "large" or "normal"
mushroom will list every position of mushroom
enermies will list every enermy in the game and their type,type 1 and 2 is available so far
stickpos express the initial position of stickman
flag will list the position of flag
cloudvelocity is useless so far

example:
[
{
    "levelStructure": {
      "levelSize" : {
        "height" : 500.0,
        "width" : 1000.0
      },
      "mushroom": [{"x": 130,"y":234}，{"x":110,"y":235}],
      "foot_tile" : [{"x": 130.0, "y": 250.0}],
      "stickmanSize": "large",

      "enermies": [{"x": 130,"y":234, "type": 1}],
      "stickmanPos": {
        "x": 20.0,
        "y": 250.0
      },
      "flag" : {"x": 130.0, "y": 0.0},
      "cloudVelocity": 3.2,
    }
  },
  {
      "levelStructure": {
        "levelSize" : {
          "height" : 500.0,
          "width" : 1000.0
        },
        "mushroom": [{"x": 130,"y":234}，{"x":110,"y":235}],
        "foot_tile" : [{"x": 130.0, "y": 250.0}],
        "stickmanSize": "large",

        "enermies": [{"x": 130,"y":234, "type": 1}],
        "stickmanPos": {
          "x": 20.0,
          "y": 250.0
        },
        "flag" : {"x": 130.0, "y": 0.0},
        "cloudVelocity": 3.2,
      }
    }
]



JSON file name: "src/main/resources/configuration.json", I wrote differnt levels into one single File.

how to load different level:
approach 1: play the game directly, touch the flag, it switch to next level in 5 seconds delay. if there are no nextlevel, it will keep showing "passed" word
approach 2: change the configuration file,by the format
approach 3: in constructor of src/main/java/stickman/model/GameEngineImp.java, change the currentlevel from 0 to 1, I have only two level in configuration file so far.


How to play:
Moving of stickman: up,left,right
shooting of stickman: space

