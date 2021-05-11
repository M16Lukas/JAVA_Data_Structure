public class OrthoPolygon {
  private int n; // 꼭지점의 갯수
  private MyPoint[] vertices; // 꼭지점 저장 배열

  public OrthoPolygon(int n) {
    this.n = 0;
    vertices = new MyPoint[n];
  }

  public int getN() {
    return n;
  }

  public void setN(int n) {
    this.n = n;
  }

  public MyPoint[] getVertices() {
    return vertices;
  }

  public void setVertices(MyPoint[] vertices) {
    this.vertices = vertices;
  }

  // 꼭지점 좌표 추가
  public void addVertex(int x, int y) {
    vertices[n++] = new MyPoint(x, y);
  }

  // x의 최대값
  public int maxX() {
    int max = vertices[0].getX();
    for (int i = 0; i < n; i++) {
      if (vertices[i].getX() > max) {
        max = vertices[i].getX();
      }
    }
    return max;
  }

  // [ 내부 / 외부 검사 ]
  // 점에서 시작하여 한 방향으로 무한히 뻗어가는 아무 직선이나
  // 하나 그어서 그것이 다각형의 변과 짝수 번 교차하면 외부에 있고
  // 홀수 번 교차하면 내부에 있다.

  // 문제를 단순화하기 위해 꼭지점의 좌표값은 모두 짝수
  // 검사할 점 p의 좌표값은 홀수로 가정한다.
  public boolean contains(MyPoint p) {
    OrthoLine arrow = new OrthoLine(p, new MyPoint(maxX() + 1, p.getY());
    int count = 0;
    for (int i = 0; i < n; i++) {
      OrthoLine edge = new OrthoLine(vertices[i], vertices[(i+1) % n]);
      if (arrow.intersects(edge)) {
        count++;
      }
    }
    return (count % 2 == 1);
  }
}
