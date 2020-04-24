package spring3;

import java.io.IOException;

//sayHello()통해서 출력할 메세지의 내용을 매개변수받아서 출력메서드 선언
public interface OutFile {
        void out(String message) throws IOException;
}
