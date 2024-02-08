#include<iostream>
#include <stdio.h>
#include<string>
#include<math.h>
#include<windows.h>
#include <GL/glut.h>
using namespace std;

void myDisplay();
void myInit();
void display();
void fpage();
void draw(float x, float y, const char* text);
void plane();
void box();
void menu();
void inst();

string scoring;
int score = 0;
int flag = 1;
int count_r = 0;
int x;
int y;
int px = 0;
int px1 = 0;
int px2 = 0;
int px3 = 0;
int py = 0;
int pyvmax = 0;
int pyvmin = 0;
int py1 = 0;
int py2 = 0;
int py3 = 0;
int bx = 0;
int bxmax = 0;
int bxmin = 0;
int by = 0;
int bymax = 0;
int bymin = 0;

void draw(float x, float y, const char* text) {
	glRasterPos2f(x, y);
	while (*text)
	{
		glutBitmapCharacter(GLUT_BITMAP_TIMES_ROMAN_24, *text);
		text++;
	}
}

void fpage(void)
{
	glutFullScreen();
	glClearColor(0.0, 0.0, 0.0, 0.0);
	glClear(GL_COLOR_BUFFER_BIT);
	glColor3f(0.0, 0.8, 1.0);
	draw(220, 380, "JNN COLLEGE OF ENGINEERING");
	glColor3f(1.0, 0.0, 1.0);
	draw(170, 350, "DEPARTMENT OF COMPUTER SCIENCE AND ENGINEERING");
	glColor3f(1.0, 1.0, 0.0);
	draw(220, 300, "Computer Graphics Mini Project On");
	glColor3f(0.8, 0.0, 0.4);
	draw(240, 280, "STUNT PLANE GAME");
	glColor3f(1.0, 1.0, 1.2);
	draw(260, 260, "Submitted By");
	draw(220, 240, "4JN20CS005          Akshatha A P");
	draw(220, 220, "4JN20CS024          Chaithra R");
	draw(220, 200, "4JN20CS050          Madhura S");
	draw(220, 180, "4JN20CS127          Chandana C Sagar");
	glColor3f(1.0, 0.0, 0.9);
	draw(250, 160, "Under the guidance of");
	glColor3f(1.0, 1.0, 1.2);
	draw(150, 140, "Mrs.Sushma R B");
	draw(150, 120, "Asst.Professor");
	draw(150, 100, "Dept.of CS&E");
	draw(130, 80, "Academic Year 2022-2023");
	draw(370, 140, "Mrs.Sreedevi S");
	draw(370, 120, "Asst.Professor");
	draw(370, 100, "Dept.of CS&E");
	draw(350, 80, "Academic Year 2022-2023");
	glColor3f(1.0, 1.0, 0.0);
	draw(260, 50, "Press 'm' to continue");
	glFlush();
	glutSwapBuffers();
}

void menu()
{
	glClearColor(0.0, 0.0, 0.0, 0.0);
	glClear(GL_COLOR_BUFFER_BIT);
	glColor3f(0.0, 0.8, 1.0);
	draw(250, 350, "STUNT PLANE GAME");
	glColor3f(1.0, 1.0, 0.0);
	draw(280, 280, "MENU");
	glColor3f(1.0, 1.0, 1.2);
	draw(250, 240, "Press 'a' to start the game");
	draw(250, 210, "Press 'i' to get instructions of the game");
	draw(250, 180, "Press 'q' to quit from the game");
	glFlush();
}

void inst()
{
	glClearColor(0.0, 0.0, 0.0, 0.0);
	glClear(GL_COLOR_BUFFER_BIT);
	glColor3f(1.0, 1.0, 0.0);
	draw(250, 300, "INSTRUCTIONS");
	glColor3f(1.0, 1.0, 1.2);
	draw(210, 240, "Press 'w' for the upward movement of plane");
	draw(210, 210, "Press 's' for the downward movement of plane");
	draw(210, 180, "Press 'r' to Retry the game");
	glColor3f(0.0, 0.8, 1.0);
	draw(230, 90, "Press  'a' to start the game");
	glFlush();
}

void drawGameOverText() {

	glColor3f(255, 0, 0);
	string str;

	str = "Game Over!!  Press R to Retry";

	const char* text = str.data();
	int length = str.size();
	int x = 200, y = 200;

	glColor3f(1, 0, 0);
	glRasterPos2f(x, y);
	while (*text) {
		glutBitmapCharacter(GLUT_BITMAP_HELVETICA_18, *text);
		text++;
	}
}

void keyboard(unsigned char key, int x, int y)
{
	if (key == 'a')
	{
		if (flag == 0)
			myDisplay();
		else {
			flag = 0;
			myDisplay();
		}
	}
	if (key == 'm')
	{
		menu();
	}
	if (key == 'i')
	{
		inst();
	}
	if (key == 'q')
	{
		exit(0);
	}

	if (key == 'w')
	{

		if (py1 > bymin && py1<bymax && px1>bxmin && px1 < bxmax)
		{
			bx = bx;
			by = by;
			count_r++;
		}
		else if (py2 > bymin && py2<bymax && px2>bxmin && px2 < bxmax)
		{
			bx = bx;
			by = by;
			count_r++;
		}
		else if (py3 > bymin && py3<bymax && px3>bxmin && px3 < bxmax)
		{
			bx = bx;
			by = by;
			count_r++;
		}
		else if (pyvmax < 365)
		{
			py = py + 2;
			bx = bx - 8;
			if (bx < -600)
			{
				bx = 0;
				score++;
				by = rand() % 365;
			}
			x++;
		}

		else if (bx < -600)
		{
			bx = 0;
			score++;
			by = rand() % 365;
			x++;
		}

		else {
			bx = bx - 8;
		}
		glutPostRedisplay();
	}
	else if (key == 's')
	{
		if (py1 > bymin && py1<bymax && px1>bxmin && px1 < bxmax)
		{
			bx = bx;
			by = by;
			count_r++;
		}
		else if (py2 > bymin && py2<bymax && px2>bxmin && px2 < bxmax)
		{
			bx = bx;
			by = by;
			count_r++;
		}
		else if (py3 > bymin && py3<bymax && px3>bxmin && px3 < bxmax)
		{
			bx = bx;
			by = by;
			count_r++;

		}
		else if (pyvmin > 0)
		{
			py = py - 2;
			bx = bx - 8;
			if (bx < -600)
			{
				bx = 0;
				score++;
				by = rand() % 365;
			}
		}
		else if (bx < -600)
		{
			bx = 0;
			score++;
			by = rand() % 365;
		}
		else {
			bx = bx - 8;
		}
		glutPostRedisplay();
	}
	else if (key == 'r')
	{
		py = 0;
		bx = 0;
		by = 0;
		score = 0;
		glutPostRedisplay();
	}
}

void plane()
{
	px1 = 250 + px;
	py1 = 340 + py;
	pyvmax = py1;
	pyvmin = 310 + py;
	px2 = 165 + px;
	py2 = pyvmin;
	px3 = 170 + px;
	py3 = py1;
	//down triangle of plane
	glColor3f(0.747, 0.747, 0.747);
	glBegin(GL_POLYGON);
	glVertex2i(px2, pyvmin);
	glVertex2i(px1, py1);
	glVertex2i(170 + px, 340 + py);
	glEnd();
	//upper triangle of plane
	glColor3f(0.847, 0.847, 0.847);
	glBegin(GL_POLYGON);
	glVertex2i(160 + px, 330 + py);
	glVertex2i(250 + px, 340 + py);
	glVertex2i(px3, 340 + py);
	glEnd();
}
void box()
{
	bxmax = 600 + bx;
	bxmin = 550 + bx;
	bymax = 200 + by;
	bymin = 0 + by;

	glColor3f(0.6123, 1.0, 0.6563);
	glBegin(GL_POLYGON);
	glVertex2i(bxmin, bymin);
	glVertex2i(bxmax, bymin);
	glVertex2i(600 + bx, bymax);
	glVertex2i(550 + bx, bymax);
	glEnd();
}

void myDisplay(void)
{
	glClear(GL_COLOR_BUFFER_BIT);
	plane();
	box();
	scoring = " Score: " + to_string(score);
	glColor3f(1, 0.123, 0);
	draw(280, 380, scoring.data());
	glEnd();
	if (count_r > 0) {
		drawGameOverText();
		count_r = 0;
	}
	glFlush();
}

void display(void)
{
	glClear(GL_COLOR_BUFFER_BIT);
	if (flag == 1) {
		fpage();
	}
	else {
		myDisplay();
	}
}

void myInit(void)
{
	glClearColor(1.0, 1.0, 1.0, 0.0);
	glColor3f(0.0f, 0.0f, 0.0f);
	glPointSize(4.0);
	glMatrixMode(GL_PROJECTION);
	glLoadIdentity();
	gluOrtho2D(0.0, 600.0, 0.0, 400.0);
}

int main(int argc, char** argv)
{
	glutInit(&argc, argv);
	glutInitDisplayMode(GLUT_SINGLE | GLUT_RGB);
	glutInitWindowSize(700, 500);
	glutInitWindowPosition(10, 10);
	glutCreateWindow("Stunt plane");
	glutDisplayFunc(display);
	glutKeyboardFunc(keyboard);
	myInit();
	glutMainLoop();
}