from dao.dao_set import DaoSet as dao


class StudentDao(dao):
  def __init__(self):
    self.conn = dao.connect(self)
    self.cursor = self.con.cursor()

  def __del__(self):
    try:
      self.disconnect()
    except Exception as e:
      print(e)

  # 가입된 리스트 불러오기
  def get_all(self):
    rs = self.cursor.execute("select * from student ")
    return rs.fetchall()

  # 로그인 유효성 검사
  def login_check(self, std):
    rs = self.cursor.execute(f"select  * from student "
                             f"where id='{std.id}' and pw='{std.pw}'")
    return rs.fetchone()

  # 회원가입
  def insert_one(self, std):
    self.cursor.execute(f"insert into student (id, pw, name) "
                        f"values('{std.id}','{std.pw}','{std.name}')")
    self.conn.commit()
    return self.cursor.lastrowid
  
  # 수정
  def modify_one(self, std):
    self.cursor.execute(
      f"update student set name='{std.name}', pw='{std.pw}' "
      f"where id='{std.id}' ")
    self.conn.commit()
    return self.cursor.rowcount

  # 삭제
  def delete_one(self, std):
    self.cursor.execute(f"delete from student where id='{std.id}' ")
    self.conn.commit()
    return self.cursor.rowcount