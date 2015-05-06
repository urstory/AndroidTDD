package android.examples.bankbusiness;

import junit.framework.TestCase;

/**
 * Created by kicks_000 on 2015-05-03.
 */
public class AccountTest extends TestCase {

    private Account account;

    public void setUp() throws Exception {
        account = new Account(10000);
    }

    public void testAccount() throws Exception {
        // Account account = this.account;
        // setUp();


        //assertFalse(true);
    }

    public void testGetBalance() throws Exception {
        //Account account = new Account( 10000 );
       setUp();

//        if( account.getBalance() != 10000 ) {
//            fail();
//        }
        assertEquals("10000원으로 계좌 생성 후 잔고 조회", 10000, account.getBalance());

        account = new Account( 1000 );
//        if( account.getBalance() != 1000 ) {
//            fail();
//        }
        assertEquals("1000원으로 계좌 생성 후 잔고 조회", 1000, account.getBalance());

        account = new Account( 0 );
//        if( account.getBalance() != 0 ) {
//            fail();
//        }
        assertEquals("1000원으로 계좌 생성 후 잔고 조회", 0, account.getBalance());
    }

    public void testDeposit() throws Exception {
        //Account account = new Account( 10000 );
        setUp();

        account.deposit( 1000 );
        assertEquals( "잔고 10000원 통장에 1000원 입금한 결과:", 11000, account.getBalance() );
    }

    public void testWithdraw() throws Exception {
        //Account account = new Account( 10000 );
        setUp();
        account.withdraw( 1000 );
        assertEquals( "잔고 10000원 통장에 1000원 출금한 결과:", 9000, account.getBalance() );
    }
}
