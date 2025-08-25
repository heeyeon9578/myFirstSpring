package hello.hello_spring.repositiory;

import hello.hello_spring.domain.Member;
import hello.hello_spring.repository.MemberRepository;
import hello.hello_spring.repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class MemoryMemberRepositoryTest {
    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach
    public void afterEach(){
        repository.clearStore();
    }
    @Test
    public void save(){
        Member member = new Member();
        member.setName("spring");
        repository.save(member);
        Member result =  repository.findById(member.getId()).get();
        //System.out.println("result="+(result == member));
        Assertions.assertEquals(member, result);

    }

    @Test
    public  void findByName(){
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member3 = new Member();
        member3.setName("spring3");
        repository.save(member3);

        Member result = repository.findByName("spring1").get();
        Assertions.assertEquals(member1, result);

        //Assertions.assertThat(result).isEqulTo(member1);

    }

    @Test
    public void findAll(){
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member3 = new Member();
        member3.setName("spring3");
        repository.save(member3);

        List<Member> result = repository.findAll();

        Assertions.assertEquals(result.size(), 2);
    }
}
