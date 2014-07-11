package ITint5;

public class CopyListWithRandomPtr {
	static class ListNode {
		public ListNode next = null;
		public ListNode random = null;
		public int val;
	};
	public ListNode copyListWithRandomPtr( ListNode head )
	{

		if ( head == null )

			return null;

		ListNode run = connect( head );

		ListNode dummyH = new ListNode();

		dummyH.next = run;

		while ( run != null && run.next != null )
		{

			run.next.random = run.random == null ? null : ( run.random.next );

			run = run.next.next;

		}

		return recover( dummyH.next )[ 1 ];

	}

	public ListNode connect( ListNode head )
	{

		if ( head == null )

			return head;

		ListNode next = head.next;

		head.next = new ListNode();

		//head.next.val = head.val;

		head.next.next = connect( next );

		return head;

	}

	public ListNode[ ] recover( ListNode head )
	{

		if ( head == null )

			return new ListNode[2];

		ListNode h2 = head.next;
		//System.out.println( h2.val);
		ListNode next2 = h2.next;
		ListNode[] next = recover(next2);
		head.next = next[0];
		h2.next = next[ 1 ];

		ListNode[] res = new ListNode[2];
		res[0]	=  head;
		res[1] 	=  h2;
		return res;

	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CopyListWithRandomPtr o = new CopyListWithRandomPtr();
		ListNode h1 = new ListNode();
		h1.val = 1;
		ListNode h2 = o.copyListWithRandomPtr(h1);
		System.out.println(h2.val);
	}

}
