class Student:
  @property
  def stdno(self): return self.__stdno

  @stdno.setter
  def stdno(self, stdno): self.__stdno = stdno

  @stdno.getter
  def stdno(self): return self.__stdno

  @property
  def name(self): return self.__name

  @name.setter
  def name(self, name): self.__name = name

  @name.getter
  def name(self): return self.__name

  @property
  def id(self): return self.__id

  @id.setter
  def id(self, id): self.__id = id

  @id.getter
  def id(self): return self.__id

  @property
  def pw(self): return self.__pw

  @pw.setter
  def pw(self, pw): self.__pw = pw

  @pw.getter
  def pw(self): return self.__pw

  def __str__(self): return f'{self.stdno}, {self.name()}, {self.id}, {self.pw}'

  @classmethod
  def from_str(cls, student_from_str) -> 'Student':
    std_list = student_from_str.split(',')

    student = Student()
    student.stdno = std_list[0]
    student.name = std_list[1]
    student.id = std_list[2]
    student.pw = std_list[3]
    return student












