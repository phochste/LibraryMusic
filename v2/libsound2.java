import processing.core.*; 
import processing.xml.*; 

import arb.soundcipher.*; 

import java.applet.*; 
import java.awt.Dimension; 
import java.awt.Frame; 
import java.awt.event.MouseEvent; 
import java.awt.event.KeyEvent; 
import java.awt.event.FocusEvent; 
import java.awt.Image; 
import java.io.*; 
import java.net.*; 
import java.text.*; 
import java.util.*; 
import java.util.zip.*; 
import java.util.regex.*; 

public class libsound2 extends PApplet {



int WIDTH  = 805;
int HEIGHT = 405;
int CELL_SIZE = 20;
int CELL_COLOR = 0xff333333;
int CELL_BORDER = 5;

Grid g;
Matrix m;
Matrix beam;


Synth synth = new Synth(this);
Synth synth_piano = new Synth(this);
Synth synth_violin = new Synth(this);

float[] pitchSet = {57, 60, 60, 60, 62, 64, 67, 67, 69, 72, 72, 72, 74, 76, 79};
float setSize = pitchSet.length;
float keyRoot = 0;
float density = 0.8f;

int[] music = {8192,8192,131072,256,64,8192,8,80,64,8192,131072,
640,208,64,64,128,32,64,131072,131072,8,131072,131072,128,96,64,
2080,64,2048,64,260,128,64,64,128,73728,65536,2112,147456,200,192,
68,64,64,256,2240,64,192,16,2112,192,2112,2112,4,64,64,144,131328,
2048,268,2048,133312,128,8192,65552,131472,131140,131072,8256,24896,
212,128,128,131072,8192,128,256,4164,4,65536,128,64,192,128,131072,256,
64,2176,256,384,300,16,8192,336,64,131264,256,65536,4,131264,141376,8192,
2112,8456,11584,2304,192,64,137216,131072,133120,131200,8,2076,64,2116,131112,
448,64,65920,576,32832,256,256,2048,2048,192,131072,139332,2372,8192,8608,131520,
131648,10240,131136,192,84,131076,133192,2116,104,64,10240,2144,64,2176,131080,
2048,133120,131584,64,163904,36,131072,131136,32,64,100,131328,131152,131136,64,
512,2432,131328,320,1152,32,4264,8,128,131072,133120,131136,64,448,32,2560,2112,
131072,320,131072,8};

int x = 0;
int counter = 0;

public void setup() {
  frameRate(5);
  size(WIDTH,HEIGHT);
  background(0xff000000);
  
  g = new Grid(CELL_SIZE, CELL_BORDER, CELL_COLOR);
  
  m = g.newMatrix();
  beam = g.newMatrix();
  
  synth_violin.instrument(49);
}

public void draw() {  
  // Set the sample
  if (counter * g.gWidth() + g.gWidth() > music.length) {
    println("start");
    counter = 0;
  }
  int[] sample = new int[g.gWidth()];
  
  for (int i = 0 ; i < g.gWidth() - 1 ; i++) {
    sample[i] = music[counter*g.gWidth()+i];
  }
  
  m = g.newMatrix();
  m.sample(sample, 0xffcccccc);
  
  beam.write_col(x,0xff666666);
  
  g.display();
  g.display(beam);
  g.display(m);
  
  // Melody
  synth.keyRoot(keyRoot + 60);
  synth.density(random(10)+90);
  synth.duration(random(20)/10 + 0.2f);
  synth.instrument(0);
  synth.play(m.read_col(x));
  
  // Piano
  if (frameCount%20 == 0) {
    keyRoot = (random(4)-2)*2;
    density = random(7) / 10 + 0.3f;
    synth_piano.playNote(36+keyRoot, random(40) + 70, 8.0f);
  }
  
  // Violin
  if (frameCount%10 == 0) {
     float[] pitches = {pitchSet[(int)random(setSize)]+keyRoot-12, pitchSet[(int)random(setSize)]+keyRoot-12};
     synth_violin.playChord(pitches, random(50)+30, 4.0f);
  }
  
  beam.write_col(x,0);
  
  x++;
  
  if (x >= g.gWidth()) {
    x = 0;
    counter++;
  }
}

class Synth {
  SoundCipher sc;
  float duration;
  float keyRoot;
  float density;
  float[] tone_map = { 0, 2, 5, 7, 9, 12, 14, 17, 19, 21, 24, 26, 29, 31, 33, 36};
  
  Synth(PApplet _parent) {
    sc = new SoundCipher(_parent);
    keyRoot = 60;
    duration = 1.0f;
    density = 100;
  }
  
  public void density(float d) {
    density = d;
  }
  
  public void keyRoot(float b) {
    keyRoot = b;
  }
  
  public void duration(float d) {
    duration = d;
  }
  
  public void instrument(double inst) {
    sc.instrument(inst);
  }
  
  public void play(float[] chord) {
    if (chord.length > 0) {
      for (int i = 0 ; i < chord.length ; i++) {
        chord[i] = keyRoot + tone_map[ (int) chord[i] ];
      }
      
      sc.playChord(chord , density, duration);
    }
  }
  
  public void playNote(float n, float s, float d) {
    sc.playNote(n,s,d);
  } 
  
  public void playChord(float[] c, float s, float d) {
    sc.playChord(c,s,d);
  }
}

class Matrix {
  int[][] m_data;
  int m_width;
  int m_height;
  
  Matrix(int _width, int _height) {
    m_width  = _width;
    m_height = _height;
    m_data = new int[_width][_height];
  }
  
  Matrix(int[][] _data) {
    m_data = _data;
  }
  
  public int[][] read() {
    return m_data;
  }
  
  public int read(int i, int j) {
    return m_data[i][j];
  }
  
  public void write(int[][] _data) {
    m_data = _data;
  }
  
  public void write(int i, int j, int value) {
    m_data[i][j] = value;
  }

  public float[] read_col(int i) {
    java.util.Vector vec = new java.util.Vector();
    
    for (int j = 0 ; j < m_height ; j++) {
      if (m_data[i][j] != 0) {
        vec.add(new Float(m_height - j - 1));
      }
    }
    
    float[] ret = new float[vec.size()];
    for (int n = 0 ; n < vec.size() ; n++) {
      ret[n] = ((Float) vec.get(n)).floatValue();
    }
    
    return ret;
  }
  
  public void write_col(int i, int value) {
    for (int j = 0 ; j < m_height ; j++) {
      m_data[i][j] = value;
    }
  }
  
  public float[] read_row(int j) {
    java.util.Vector vec = new java.util.Vector();
    
    for (int i = 0 ; i < m_width ; i++) {
      if (m_data[i][j] != 0) {
        vec.add(new Float(i));
      }
    }

    float[] ret = new float[vec.size()];
    for (int n = 0 ; n < vec.size() ; n++) {
      ret[n] = ((Float) vec.get(n)).floatValue();
    }
    
    return ret;
  }
  
  public void write_row(int j, int value) {
    for (int i = 0 ; i < m_width ; i++) {
      m_data[i][j] = value;
    }
  }
  
  public void sample(int[] s, int value) {
    for (int i = 0 ; i < m_width - 1 ; i++) {
      if (i > s.length - 1) {
        return;
      }
      for (int j = 0 ; j < m_height - 1 ; j++) {
        int _mask = 1 << j;
        if ( (s[i] & _mask) == _mask) {
          m_data[i][j] = value;
        }
      }
    }
  }
  
  public void sample(int[][] s, int value) {
    for (int i = 0 ; i < s.length && i < m_width ; i++) {
      for (int j = 0 ; j < s[i].length ; j++) {
        m_data[i][m_height - s[i][j] - 1] = value;
      }
    }
  }
}

class Grid {
  int c_size;
  int c_color;
  int c_border;
  int c_width;
  int c_height;
  
  Grid(int _size, int _border, int _color) {
    c_size   = _size;
    c_border = _border; 
    c_color  = _color; 
    c_width  = width / (c_size + c_border);
    c_height = height / (c_size + c_border);
  }
  
  public int gWidth() {
    return c_width;
  }
  
  public int gHeight() {
    return c_height;
  }
  
  public Matrix newMatrix() {
    return new Matrix(c_width,c_height);
  }
  
  public void display() {
    fill(c_color);
    
    for (int x = c_border ; x <= width - c_size - c_border; x += c_size + c_border) {
      for (int y = c_border ; y <= height - c_size - c_border; y += c_size + c_border) {
        rect(x,y, c_size, c_size);
      }
    }
  }
  
  public void display(Matrix m) {
    for (int x = c_border ; x <= width - c_size - c_border; x += c_size + c_border) {
      for (int y = c_border ; y <= height - c_size - c_border; y += c_size + c_border) {
        int i = x / (c_size + c_border);
        int j = y / (c_size + c_border);
        if (m.read(i,j) != 0) {
          fill(m.read(i,j));          
          rect(x,y, c_size, c_size);
        }
      }
    }
  }
}

  static public void main(String args[]) {
    PApplet.main(new String[] { "--present", "--bgcolor=#666666", "--stop-color=#cccccc", "libsound2" });
  }
}
