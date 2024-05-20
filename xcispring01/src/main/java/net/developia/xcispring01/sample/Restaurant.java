package net.developia.xcispring01.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.Setter;


@Data
@Component
public class Restaurant {
	    @Setter(onMethod_ = @Autowired)
	    //Outline에서 확인 할 수 없다는 차이가 있지만 아래처럼 써도 된다.
	    //@Autowired
	    private Chef chef;

	}

