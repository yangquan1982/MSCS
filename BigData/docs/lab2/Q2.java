int f(x) {
	if(x==3){return 3;} 
	else if(x!=3){return -3;}
	else if(x==4){return 4;} 
	else if(x!=4&&x!=3){return 2;}
}

int g(x,y) {
	if(x==1){return 1;}
	else if((x==0||x==2||x==4)&&y==3){return 1;}
	else if((x==0||x==2)&&y==2){return 2;} 
	else if((x==0||x==2)&&y==4)||(x==4&&y==-3)){return 4;}
}