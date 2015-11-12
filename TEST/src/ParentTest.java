public static boolean mat chParens(char[] arr){

    Map<Character, Character> map = new Hashmap<Character, Character>();
    map.add('(', ')');
    map.add('[', ']');

    Stack<Character> stack = new Stack<Character>();
    
    boolean rtn = false;
    
    for(int i = 0; i < arr.length; ++i){
        if(arr[i] == '(' || arr[i] == '['){
            stack.push(arr[i]);
        }
        else{
            if(stack.isEmpty()){
                stack.push(arr[i]);
                break;
            }
        
            if(map.get(stack.peek()) != arr[i]){
                break;
            }
            else{
                stack.pop();
                continue;
            }
        }
    }
    if(stack.isEmply())
        rtn = true;

    return rtn;
}