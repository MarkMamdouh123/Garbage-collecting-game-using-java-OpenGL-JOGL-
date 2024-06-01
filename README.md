 a 2D garbage collecting game using Java OpenGL (JOGL). The primary objective is to collect paper falling from sky with a trash bin. Players control a trash bin, aiming to catch falling paper objects. The game includes collision detection, score tracking, and dynamic graphics rendering.
Game Components
The game is structured into several classes across different files, each handling distinct functionalities:
1.	EventListener (org.graphics.EventListener)
2.	Render (org.graphics.Render)
3.	KeyInput (org.input.KeyInput)
4.	ImageResource (org.resource.ImageResource)
5.	Graphics (org.graphics.Graphics

1.	EventListener
The EventListener class handles the game's main logic, including rendering graphics, updating game states, and detecting collisions. It implements the GLEventListener interface, which requires methods for initialization, display, disposal, and reshaping.
•	Initialization: Sets up OpenGL settings and the text renderer for displaying the score.
•	Display: This method is the main rendering loop of the game. It clears the screen, draws the background, trash bin, and falling paper objects. It also updates the position and rotation of the falling paper, checks for collisions between the paper and the trash bin, updates the score, and handles the game over condition. The paper's position is continuously updated to create a falling effect, and its rotation is incremented to add visual interest.
•	Collision Detection: The checkCollision method is used to determine if the falling paper intersects with the trash bin. This is achieved by comparing the positions and dimensions of the two objects. If a collision is detected, the score is increased, and the paper is reset to a new random position at the top of the screen.
2.	Render
The Render class is responsible for setting up the OpenGL window and managing window properties and animations. It initializes the OpenGL profile and capabilities, creates the window, and attaches the EventListener and KeyInput classes to handle rendering and user input, respectively.
•	Initialization: This method initializes the OpenGL environment, creates the window, and sets its properties such as visibility, resizability, and size. It also starts an animation loop using FPSAnimator to ensure smooth rendering at 60 frames per second.
3.	KeyInput
The KeyInput class manages keyboard interactions, allowing players to control the trash bin.
•	Key Press Handling: This method allows the trash bin to be moved left or right in response to the arrow keys. The trash bin's position is updated based on the key pressed, ensuring it stays within the bounds of the window. This enables players to position the bin to catch the falling paper.
ImageResource
The ImageResource class handles loading and managing textures used in the game. It loads images from specified paths and converts them into OpenGL textures.
•	Texture Loading: This method reads an image file from a specified path, creates a BufferedImage, and then converts it into an OpenGL texture using the AWTTextureIO utility. The texture is then used for rendering images in the game.
Graphics
The Graphics class provides methods for rendering images and shapes on the screen. It abstracts the OpenGL drawing functions to simplify the rendering process.
•	Drawing Images: This method includes functionality for drawing images at specified coordinates with specified dimensions. It also supports applying transformations such as rotation and scaling. The class ensures that the images are rendered with the correct colors and transparency.
Game Logic and Flow
1.	Game Start: The game starts with the initialization of the OpenGL environment and the display of the initial game screen. The background, trash bin, and paper objects are drawn on the screen.
2.	Game Loop: The main game loop continuously updates the position of the falling paper, checks for collisions, and updates the score. The paper falls from the top of the screen, and the player moves the trash bin left or right to catch the paper.
3.	Collision Detection and Scoring: When the paper intersects with the trash bin, the score is increased, and the paper is reset to a new position at the top of the screen. If the paper falls beyond the trash bin without being caught, the game ends, and a "Game Over" message is displayed with the final score.
4.	Game Over: When the game ends, a message box is displayed showing the player's score. The game window is then closed, and the application exits.

