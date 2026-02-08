public class Trees1
{

    public static boolean check(BinNode<Integer> t)
    {
        if (t == null)
        {
            return false;
        }
        if (t.getValue() % 2 != 0)
        {
            return false;
        }
        if (t.hasLeft())
        {
            if (t.getLeft().getValue() % 2 != 0)
            {
                return false;
            }
        }
        if (t.hasRight())
        {
            if (t.getRight().getValue() % 2 != 0)
            {
                return false;
            }
        }
        return true;
    }

    public static void p1(BinNode<Integer> t)
    {
        if (t != null)
        {
            if (check(t))
            {
                System.out.println(t.getValue());
            }
            p1(t.getLeft());
            p1(t.getRight());
        }
    }

    public static int f2(BinNode<Integer> t)
    {
        if (t == null)
        {
            return 0;
        }
        int c = 0;
        if (check(t))
        {
            c = 1;
        }
        return c + f2(t.getLeft()) + f2(t.getRight());
    }

    public static boolean f3(BinNode<Integer> t)
    {
        if (t == null)
        {
            return false;
        }
        if (check(t))
        {
            return true;
        }
        return f3(t.getLeft()) || f3(t.getRight());
    }

    public static boolean f4(BinNode<Integer> t)
    {
        if (t == null)
        {
            return true;
        }
        if (!check(t))
        {
            return false;
        }
        return f4(t.getLeft()) && f4(t.getRight());
    }

    public static void main(String[] args)
    {
        BinNode<Integer> n1 = new BinNode<Integer>(2);
        BinNode<Integer> n2 = new BinNode<Integer>(4);
        BinNode<Integer> t = new BinNode<Integer>(n1, 6, n2);

        System.out.println("Nodes:");
        p1(t);

        int res2 = f2(t);
        System.out.println("Count: " + res2);

        boolean res3 = f3(t);
        System.out.println("Exists: " + res3);

        boolean res4 = f4(t);
        System.out.println("All: " + res4);
    }
}


public class Trees2 {

    public static void main(String[] args) {
        BinNode<Integer> t1 = build1();
        BinNode<Integer> t2 = build2();

        System.out.println(ex14(t1));
        System.out.println(ex18(t1, t2));
        System.out.println(ex20(t1));
    }

    public static BinNode<Integer> build1() {
        BinNode<Integer> r = new BinNode<>(10);
        BinNode<Integer> l = new BinNode<>(-5);
        BinNode<Integer> n = new BinNode<>(20);
        r.setLeft(l);
        r.setRight(n);
        return r;
    }

    public static BinNode<Integer> build2() {
        BinNode<Integer> r = new BinNode<>(10);
        BinNode<Integer> l = new BinNode<>(-5);
        r.setLeft(l);
        return r;
    }

    public static int ex14(BinNode<Integer> t) {
        int c = 0;
        if (t == null)
            return 0;
        if (!t.hasLeft() && !t.hasRight())
            c++;
        return c + ex14(t.getLeft()) + ex14(t.getRight());
    }

    public static boolean ex18(BinNode<Integer> t1, BinNode<Integer> t2) {
        if (t2 == null)
            return true;
        if (!has(t1, t2.getValue()))
            return false;
        return ex18(t1, t2.getLeft()) && ex18(t1, t2.getRight());
    }

    public static boolean has(BinNode<Integer> t, int v) {
        if (t == null)
            return false;
        if (t.getValue() == v)
            return true;
        return has(t.getLeft(), v) || has(t.getRight(), v);
    }

    public static int ex20(BinNode<Integer> t) {
        if (t == null)
            return 0;
        return sPos(t) - Math.abs(sNeg(t));
    }

    public static int sPos(BinNode<Integer> t) {
        if (t == null)
            return 0;
        int s = 0;
        if (t.getValue() > 0) {
            s = t.getValue();
        }
        return s + sPos(t.getLeft()) + sPos(t.getRight());
    }

    public static int sNeg(BinNode<Integer> t) {
        if (t == null)
            return 0;
        int s = 0;
        if (t.getValue() < 0) {
            s = t.getValue();
        }
        return s + sNeg(t.getLeft()) + sNeg(t.getRight());
    }
    public static boolean q_26(BinNode<Integer> t, int x, Queue<Integer> q)
    {
        x++;
        if((t.hasRight()&&!hasLeft()) ||(!t.hasRight()&&hasLeft()))
        {
            return false;
        }
        if(!t.hasRight()&&!hasLeft())
        {
            q.insert(x);
			return true;
        }
        
        boolean y= q_26(t.hasRight())&&q_26(t.hasLeft())
        
        if (x==0)
        {
            if(q_26e(q)&&y)
            {
                return true;
            }
            return false;
        }
        
	}
	public static boolean q_26e(Queue<Integer> q)
    {
        while (!q.isEmpty())
        {
            int c=q.remove();
            if (!q.isEmpty())
            {
                if (c!=q.head())
                {
                    return false
                }
            }
        }
        return true;
    }
}
