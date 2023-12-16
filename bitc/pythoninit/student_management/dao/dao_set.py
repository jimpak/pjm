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

'''
CREATE TABLE student (stdno integer primary key autoincrement, name char(20), id char(20), pw char(20));
sqlite> .table
student
sqlite> .schema student
CREATE TABLE student (stdno integer primary key autoincrement, name char(20), id char(20), pw char(20));
sqlite> insert into student(name, id, pw) values('std01','std01',1);
sqlite> select * from student;
1|std01|std01|1
'''



















