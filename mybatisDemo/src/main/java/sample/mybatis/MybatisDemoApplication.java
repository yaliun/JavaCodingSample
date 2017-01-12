package sample.mybatis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import sample.mybatis.dao.CityDao;
import sample.mybatis.mapper.HotelMapper;

@SpringBootApplication
public class MybatisDemoApplication implements CommandLineRunner{

	@Autowired
	private CityDao cityDao;

	@Autowired
	private HotelMapper hotelMapper;

	public static void main(String[] args) {
		SpringApplication.run(MybatisDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println(this.cityDao.selectCityById(1));
		System.out.println(this.hotelMapper.selectByCityId(1));
	}

}
