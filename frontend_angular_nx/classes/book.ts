
  export class Book {
    public showFullDescription: boolean;
    constructor(
      public id: number,
      public title: string,
      public authors: string,
      public description: string,
      public genders: string,
      public lang: string,
      public image: string,
      public rating: number,
      public numVotes: number
    ) {
      this.showFullDescription = false;
    }
  }