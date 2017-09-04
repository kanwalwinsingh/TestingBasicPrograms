package VendingMachineJavaRevisited;

import java.util.List;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import jdk.nashorn.internal.ir.annotations.Ignore;

public class VendingMachineTest {

	private static VendingMachine vm;
	
	@BeforeClass
	public static void setUp(){
		vm = VendingMachineFactory.createdVendingMachine();
	}
	
	@AfterClass
	public static void tearDown(){
		vm = null;
	}
	
/*	@Test
	public void testBuyItemWithExactPrice(){
		//select item, price in cents
		long price = vm.selectItemAndGetPrice(Item.COKE);
		
		//price should be Coke's price
		Assert.assertEquals(Item.COKE.getPrice(), price);
		
		vm.insertCoin(Coin.QUARTER);
		
		Bucket<Item, List<Coin>> bucket = vm.collectItemAndChange();
		Item item = bucket.getFirst();
		List<Coin> change = bucket.getSecond();
		
		//should be coke
		Assert.assertEquals(Item.COKE, item);
		
		Assert.assertTrue(change.isEmpty());
	}*/
	
	@Test
	public void testBuyItemWithMorePrice(){
		long price = vm.selectItemAndGetPrice(Item.SODA);
		Assert.assertEquals(Item.SODA.getPrice(), price);
		
		vm.insertCoin(Coin.QUARTER);
		vm.insertCoin(Coin.QUARTER);
		
		Bucket<Item, List<Coin>> bucket = vm.collectItemAndChange();
		Item item = bucket.getFirst();
		List<Coin> change = bucket.getSecond();
		
		//should be Soda
		Assert.assertEquals(Item.SODA, item);
		Assert.assertEquals(50-Item.SODA.getPrice(), getTotal(change));
		
	}
	
	/*@Test
	public void testRefund(){
		long price = vm.selectItemAndGetPrice(Item.PEPSI);
		Assert.assertEquals(Item.PEPSI.getPrice(), price);
		vm.insertCoin(Coin.DIME);
		vm.insertCoin(Coin.NICKLE);
		vm.insertCoin(Coin.PENNY);
		vm.insertCoin(Coin.QUARTER);
		Assert.assertEquals(41, getTotal(vm.refund()));
	}
	
	
	@Test(expected=SoldOutException.class)
	public void testSoldOut(){
		for(int i=0;i<5;i++){
		vm.selectItemAndGetPrice(Item.COKE);
		vm.insertCoin(Coin.QUARTER);
		vm.collectItemAndChange();
		}
	}
	
	@Test(expected = NotSufficentChangeException.class)
	public void testNotSufficientChangeException(){
		for(int i=0;i<5;i++){
			vm.selectItemAndGetPrice(Item.SODA);
			vm.insertCoin(Coin.QUARTER);
			vm.insertCoin(Coin.QUARTER);
			vm.collectItemAndChange();
			
			vm.selectItemAndGetPrice(Item.PEPSI);
			vm.insertCoin(Coin.QUARTER);
			vm.insertCoin(Coin.QUARTER);
			vm.collectItemAndChange();
		}
	}
	
	@Test(expected=SoldOutException.class)
	public void testReset(){
		VendingMachine vmMachine = VendingMachineFactory.createdVendingMachine();
		vmMachine.reset();
		vmMachine.selectItemAndGetPrice(Item.COKE);
	}
	
	@Ignore
	public void testVendingMachineImpl(){
		VendingMachineImpl vm = new VendingMachineImpl();
	}*/
	
	
	private long getTotal(List<Coin> change){
		long total = 0;
		for(Coin c: change){
			total = total+c.getDenomination();
		}
		return total;
	}
}
