from student_management.dao.dao_set import DaoSet as dao


class StudentDao(dao):
  def __init__(self):
    self.con = dao.connect(self)
    self.cursor = self.con.cursor()

  def __del__(self):
    try:
      self.disconnect()
    except Exception as e:
      print(e)

  def get_all(self):
    rs = self.cursor.execute("select * from student ")
    return rs.fetchall()

  def login_check(self, std):
    rs = self.cursor.execute(f"select  * from student "
                             f"where id='{std.id}' and pw='{std.pw}'")
    return rs.fetchone()

  def insert_one(self, std):
    self.cursor.execute(f"insert into student (id, name, pw) "
                        f"values('{std.id}','{std.name}','{std.pw}' )")
    self.conn.commit()
    return self.cursor.lastrowid

  def modify_one(self, std):
    self.cursor.execute(
      f"update student set name='{std.name}', pw='{std.pw}' "
      f"where id='{std.id}' ")
    self.conn.commit()
    return self.cursor.rowcount

  def delete_one(self, std):
    self.cursor.execute(f"delete from student where id='{std.id}' ")
    self.conn.commit()
    return self.cursor.rowcount
