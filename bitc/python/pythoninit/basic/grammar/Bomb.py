import random
import sys
import threading
import time


class Bomb(threading.Thread):
  def __init__(self):
    threading.Thread.__init__(self)
    self.life = random.randint(1,2)
    self.state = False

  def run(self):
    for i in range(10, 0, -1):
      if self.state : break;
      print(i)
      time.sleep(0.5)
    print("Bomb~!")
    sys.exit()

  def choose(self, line):
    try:
      line = int(line)
    except Exception as e:
      line = 1

    print(f'{line}을 선택하셨습니다')
    if(self.life == line):
      print('Alive~!')
    else:
      print('scream~!')

    self.state = True











