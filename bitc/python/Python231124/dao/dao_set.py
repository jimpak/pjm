import sqlite3

class DaoSet:
  def connect(self):
    self.con = sqlite3.connect("C:/workspace/sqlite-tools-win-x64-3440000/naverDB")
    return self.con

  def disconnect(self):
    try:
      if self.con != None: self.con.close()
      if self.cursor != None: self.cursor.close()
    except Exception as e:
      print(e)