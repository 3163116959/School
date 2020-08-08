package service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import entity.Student;
import mapper.StudentMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service(value = "studentService")
public class StudentService {

	@Resource(name = "studentMapper")
	private StudentMapper studentMapper;
	public void setStudentMapper(StudentMapper studentMapper) {
		this.studentMapper = studentMapper;
	}
	//查询全部学生
		//public List<Student> queryAll();
	public List<Student> queryAll(){
		List<Student> students = studentMapper.selectList(null);
		return students;
	}
		
		//根据学号查询
		//List<Student> queryByStuId(String stuId);
	public List<Student> queryByStuId(String stuId){
		QueryWrapper<Student> wrapper = new QueryWrapper<>();
		wrapper.eq("stuId",stuId);
		List<Student> students = studentMapper.selectList(wrapper);
		return students;
	}
		
		//根据班级名字查询
		//List<Student> queryByClassName(String className);
		public List<Student> queryByClassName(String className){
			QueryWrapper<Student> wrapper = new QueryWrapper<>();
			wrapper.eq("className",className);
			List<Student> students = studentMapper.selectList(wrapper);
			return students;
		}
		//根据姓名查询
		//List<Student> queryBystuName(String stuName);
		public List<Student> queryBystuName(String stuName){
			QueryWrapper<Student> wrapper = new QueryWrapper<>();
			wrapper.eq("stuName",stuName);
			List<Student> students = studentMapper.selectList(wrapper);
			return students;
		}
		//根据学号删除学生
		// public int deleteBystuId(String stuId);
		public int deleteBystuId(String stuId){
			QueryWrapper<Student> wrapper = new QueryWrapper<>();
			wrapper.eq("stuId",stuId);
			int delete = studentMapper.delete(wrapper);
			return delete;
		}

		//添加学生
		//public int addStudent(Student student);
		public int addStudent(Student student){
			int insert = studentMapper.insert(student);
			return insert;
		}

		//修改学生
		// public int alterStudent(Student student);
		public int alterStudent(Student student){
			int i = studentMapper.updateById(student);
			return i;
		}

		//查询全部学号
		// public List<String> queryStuId();
		public List<String> queryStuId(){
			List<Student> students = studentMapper.selectList(null);
			List<String> abc = new ArrayList<>();
			for (Student stu:students){
				abc.add(stu.getStuId());
			}
			return abc;
		}
}
